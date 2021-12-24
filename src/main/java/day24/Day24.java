package day24;

import com.microsoft.z3.BitVecExpr;
import com.microsoft.z3.Context;
import com.microsoft.z3.Optimize;
import day00.Day;

import java.io.InputStream;
import java.util.*;

public class Day24 extends Day {

  private BitVecExpr[] digits;
  private Optimize solver;
  private Map<String, BitVecExpr> registers;
  private Context ctx;

  public Day24() {
    ctx = new Context(Map.of("model", "true"));
  }


  @Override
  protected String part1() {
    List<String[]> prog = new ArrayList<>();
    for (String s : inputAsList())
      prog.add(s.split(" "));

    defineSolver(prog);

    var target = defineTarget();

    solver.Push();
    var solP1 = solver.MkMaximize(target);
    solver.Check();
    System.out.println("P1: " + solP1);

/*
    solver.Pop();
    var solP2 = solver.MkMinimize(target);
    solver.Check();
    System.out.println("P2: " + solP2);*/

    return solP1.toString();
  }

  @Override
  protected String part2() {
    List<String[]> prog = new ArrayList<>();
    for (String s : inputAsList())
      prog.add(s.split(" "));

    defineSolver(prog);

    var target = defineTarget();

    var sol = solver.MkMinimize(target);
    solver.Check();
    System.out.println("P2: " + sol);

    return sol.toString();
  }
  Optimize defineSolver(List<String[]> prog) {

    solver = ctx.mkOptimize();

    var zero = ctx.mkBV(0, 64);
    var one = ctx.mkBV(1, 64);
    var nove = ctx.mkBV(9, 64);

    digits = new BitVecExpr[14];
    for (int i = 0; i < digits.length; i++) {
      digits[i] = ctx.mkBVConst("d_" + i, 64);
    }
    for (BitVecExpr digit : digits) {
      solver.Add(ctx.mkBVSGE(digit, one));
      solver.Add(ctx.mkBVSLE(digit, nove));
    }

    var digitInput = Arrays.stream(digits).iterator();

    registers = new HashMap<>();
    for (String var : List.of("x", "y", "z", "w"))
      registers.put(var, zero);

    for (int i = 0; i < prog.size(); i++) {
      String[] inst = prog.get(i);

      if (inst[0].equals("inp")) {
        registers.put(inst[1], digitInput.next());
        continue;
      }

      var c = ctx.mkBVConst("c_" + i, 64);
      solver.Add(
          switch (inst[0]) {
            case "add" -> ctx.mkEq(c, ctx.mkBVAdd(op(inst[1]), op(inst[2])));
            case "mul" -> ctx.mkEq(c, ctx.mkBVMul(op(inst[1]), op(inst[2])));
            case "mod" -> ctx.mkEq(c, ctx.mkBVSMod(op(inst[1]), op(inst[2])));
            case "div" -> ctx.mkEq(c, ctx.mkBVSDiv(op(inst[1]), op(inst[2])));
            case "eql" -> ctx.mkEq(c, ctx.mkITE(ctx.mkEq(op(inst[1]), op(inst[2])), one, zero));
            default -> throw new IllegalStateException();
          });
      registers.put(inst[1], c);
    }

    solver.Add(ctx.mkEq(registers.get("z"), zero));

    return solver;
  }

  private BitVecExpr defineTarget() {
    final var target = ctx.mkBVConst("sum", 64);
    solver.Add(ctx.mkEq(
        target,
        Arrays.stream(digits).reduce((a, b) -> ctx.mkBVAdd(ctx.mkBVMul(a, ctx.mkBV(10, 64)), b)).get())
    );
    return target;
  }

  private BitVecExpr op(String inst) {
    return (registers.containsKey(inst)) ? registers.get(inst) : ctx.mkBV(inst, 64);
  }
}