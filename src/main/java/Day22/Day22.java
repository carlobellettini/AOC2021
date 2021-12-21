package Day22;

import Day00.Day;
import Day00.ReadsFormattedString;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class Day22 extends Day {


  @Override
  protected String part1() {

    List<MultiCuboid> on = new ArrayList<>();

    for (String line : inputAsList()) {
      Cuboid c;
      if (line.startsWith("on"))
        c = ReadsFormattedString.readString(line.substring(3),
            "x=%d..%d,y=%d..%d,z=%d..%d", Cuboid.class);
      else {
        c = ReadsFormattedString.readString(line.substring(4),
            "x=%d..%d,y=%d..%d,z=%d..%d", Cuboid.class);
        c.setOff();
      }

      if (c.smallCube()) {
        on.removeIf(multiCube -> multiCube.remove(c));
        if (c.on()) on.add(new MultiCuboid(c));
      }
    }

    return String.valueOf(on.stream().mapToLong(multiCube -> multiCube.count()).sum());
  }

  @Override
  protected String part2() {

    List<MultiCuboid> on = new ArrayList<>();

    for (String line : inputAsList()) {
      Cuboid c;

      if (line.startsWith("on"))
        c = ReadsFormattedString.readString(line.substring(3),
            "x=%d..%d,y=%d..%d,z=%d..%d", Cuboid.class);
      else {
        c = ReadsFormattedString.readString(line.substring(4),
            "x=%d..%d,y=%d..%d,z=%d..%d", Cuboid.class);
        c.setOff();
      }


      on.removeIf(multiCube -> multiCube.remove(c));
      if (c.on()) on.add(new MultiCuboid(c));
    }

    return String.valueOf(on.stream().mapToLong(multiCube -> multiCube.count()).sum());
  }
}

class MultiCuboid {
  Cuboid on;
  List<Cuboid> off = new ArrayList<>();

  public MultiCuboid(Cuboid on) {
    this.on = on;
  }

  @Override
  public String toString() {
    return "MultiCuboid{" +
        "on=" + on +
        ", off=" + off +
        '}';
  }

  boolean remove(Cuboid cube) {
    Optional<Cuboid> i = on.intersect(cube);
    if (i.isPresent()) { //se non c'è intersezione non fa nulla
      Cuboid offCandidate = i.get();
      if (offCandidate.equals(on)) return true; //se il multicuboide viene incluso completamente
      for (Iterator<Cuboid> iterator = off.iterator(); iterator.hasNext(); ) { //calcola quali sono
        Cuboid cubes = iterator.next();
        Optional<Cuboid> o = cubes.intersect(offCandidate);
        if (o.isPresent()) { // se ci sono intersezioni con blocchi off precedenti
          if (o.get().equals(offCandidate))
            return false; // nuovo  è già incluso
          if (o.get().equals(cubes))
            iterator.remove(); // tolgo vecchio  già incluso
          else {
            for (Cuboid nuovoCandidato : offCandidate.differenzaScomposta(o.get())) //suddivido blocco in modo da non avere sovrapposizioni
              this.remove(nuovoCandidato);
            return false;
          }
        }
      }
      off.add(offCandidate);
    }
    return false;
  }

  long count() {
    return on.size() - off.stream().mapToLong(cubes -> cubes.size()).sum();
  }
}