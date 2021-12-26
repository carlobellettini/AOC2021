package day18;


import static org.paukov.combinatorics3.Generator.combination;
import static org.paukov.combinatorics3.Generator.permutation;

import day00.Day;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.IntStream;

public class Day18 extends Day {
  @Override
  protected String part1(List<String> input) {
    Tree result = new Tree(input.get(0));

    for (int i = 1; i < input.size(); i++) {
      Tree toAdd = new Tree(input.get(i));
      result.sum(toAdd);
      result.reduce();
    }

    return "" + result.magnitude();
  }

  @Override
  protected String part2(List<String> input) {

    var combs = combination(IntStream.range(0, input.size()).boxed().toList()).simple(2).stream()
        .flatMap(c -> permutation(c).simple().stream()).toList();

    long max = 0;
    for (List<Integer> pair : combs) {
      Tree s0 = new Tree(input.get(pair.get(0)));
      Tree s1 = new Tree(input.get(pair.get(1)));

      s0.sum(s1);
      s0.reduce();

      long magn = s0.magnitude();
      if (magn > max) max = magn;
    }
    return "" + max;
  }
}

class TreeNode {
  private static TreeNode lastRegular, nextRegular, exploding, parent;
  Integer lvalue;
  Integer rvalue;
  TreeNode l;
  TreeNode r;

  void preOrderVisit(StringBuilder sb) {
    sb.append('[');

    if (lvalue != null)
      sb.append(lvalue);
    else
      l.preOrderVisit(sb);

    sb.append(',');

    if (rvalue != null)
      sb.append(rvalue);
    else
      r.preOrderVisit(sb);
    sb.append(']');
  }

  void markExploding(int level) {
    if (exploding == null && level > 4) {
      exploding = this;
      return;
    }

    if (lvalue == null) {
      if (exploding == null) parent = this;
      l.markExploding(level + 1);
    } else if (exploding == null) lastRegular = this;
    else if (nextRegular == null) nextRegular = this;

    if (rvalue == null) {
      if (exploding == null) parent = this;
      r.markExploding(level + 1);
    } else if (exploding == null) lastRegular = this;
    else if (nextRegular == null) nextRegular = this;
  }

  boolean explode() {
    lastRegular = null;
    nextRegular = null;
    exploding = null;
    parent = null;
    markExploding(1);

    if (exploding == null) return false;

    if (lastRegular != null && lastRegular.rvalue != null) lastRegular.rvalue += exploding.lvalue;
    else if (lastRegular != null && lastRegular.lvalue != null) lastRegular.lvalue += exploding.lvalue;

    if (nextRegular != null && nextRegular.lvalue != null) nextRegular.lvalue += exploding.rvalue;
    else if (nextRegular != null && nextRegular.rvalue != null) nextRegular.rvalue += exploding.rvalue;

    if (parent.l == exploding) {
      parent.l = null;
      parent.lvalue = 0;
    } else if (parent.r == exploding) {
      parent.r = null;
      parent.rvalue = 0;
    }
    return true;
  }

  boolean split() {
    if (lvalue != null && lvalue > 9) {
      l = splittedNode(lvalue);
      lvalue = null;
      return true;
    }
    if (lvalue == null)
      if (l.split()) return true;

    if (rvalue != null && rvalue > 9) {
      r = splittedNode(rvalue);
      rvalue = null;
      return true;
    }
    if (rvalue == null)
      if (r.split()) return true;
    return false;
  }

  @NotNull
  private TreeNode splittedNode(Integer lvalue) {
    TreeNode n = new TreeNode();
    n.lvalue = lvalue / 2;
    n.rvalue = lvalue - n.lvalue;
    return n;
  }

  public int magnitude() {
    return 3 * (lvalue != null ? lvalue : l.magnitude()) +
        2 * (rvalue != null ? rvalue : r.magnitude());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    preOrderVisit(sb);
    return sb.toString();
  }
}

class Tree {
  TreeNode root;

  public Tree(String def) {
    assert def.charAt(0) == '[';
    var result = createSubTree(def);
    root = result.node;
    assert result.toParse.length() == 0;
  }

  int magnitude() {
    return root.magnitude();
  }

  void sum(Tree o) {
    TreeNode t = root;
    root = new TreeNode();
    root.l = t;
    root.r = o.root;
  }

  void reduce() {
    while (root.explode() || root.split())
      ;
  }

  ParsedInt parseInt(String s) {
    int pos = 0;
    while (Character.isDigit(s.charAt(pos))) {
      pos++;
    }
    return new ParsedInt(Integer.parseInt(s.substring(0, pos)), s.substring(pos));
  }

  ParseObject createSubTree(String def) {
    assert def.charAt(0) == '[';
    TreeNode node = new TreeNode();

    if (def.charAt(1) == '[') {
      var result = createSubTree(def.substring(1));
      node.l = result.node;
      def = result.toParse;
    } else {
      var result = parseInt(def.substring(1));
      node.lvalue = result.val;
      def = result.toParse;
    }
    assert def.charAt(0) == ',';
    if (def.charAt(1) == '[') {
      var result = createSubTree(def.substring(1));
      node.r = result.node;
      def = result.toParse;
    } else {
      var result = parseInt(def.substring(1));
      node.rvalue = result.val;
      def = result.toParse;
    }
    assert def.charAt(0) == ']';
    return new ParseObject(node, def.substring(1));
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    root.preOrderVisit(sb);
    return sb.toString();
  }

  public record ParsedInt(Integer val, String toParse) {
  }

  public record ParseObject(TreeNode node, String toParse) {
  }
}