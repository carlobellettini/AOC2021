package day22;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public final class Cuboid {
  private final long x0;
  private final long x1;
  private final long y0;
  private final long y1;
  private final long z0;
  private final long z1;
  private boolean on;

  public Cuboid(long x0, long x1, long y0, long y1, long z0, long z1) {
    this.x0 = x0;
    this.x1 = x1;
    this.y0 = y0;
    this.y1 = y1;
    this.z0 = z0;
    this.z1 = z1;
    this.on = true;
  }

  @Override
  public String toString() {
    return "Cuboid{" +
         x0 +
        "," + x1 +
        ", " + y0 +
        "," + y1 +
        ", " + z0 +
        "," + z1 +
        ", " + on +
        '}';
  }

  void setOff() {
    this.on = false;
  }

  Optional<Cuboid> intersect(Cuboid o) {
    if (x0 > o.x1 || o.x0 > x1 ||
        y0 > o.y1 || o.y0 > y1 ||
        z0 > o.z1 || o.z0 > z1
    ) return Optional.empty();

    return Optional.of(new Cuboid(
        Math.max(x0, o.x0), Math.min(x1, o.x1),
        Math.max(y0, o.y0), Math.min(y1, o.y1),
        Math.max(z0, o.z0), Math.min(z1, o.z1)));
  }

  long size() {
    return (x1 - x0 + 1) * (y1 - y0 + 1) * (z1 - z0 + 1);
  }

  public boolean on() {
    return on;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (obj == null || obj.getClass() != this.getClass()) return false;
    var that = (Cuboid) obj;
    return this.x0 == that.x0 &&
        this.x1 == that.x1 &&
        this.y0 == that.y0 &&
        this.y1 == that.y1 &&
        this.z0 == that.z0 &&
        this.z1 == that.z1 &&
        this.on == that.on;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x0, x1, y0, y1, z0, z1, on);
  }

  public List<Cuboid> differenzaScomposta(Cuboid cube) {
    ArrayList<Cuboid> l = new ArrayList<>();
    if (cube.x0 > x0)
      l.add(new Cuboid(x0, cube.x0 - 1, y0, y1, z0, z1));
    if (cube.x1 < x1)
      l.add(new Cuboid(cube.x1 + 1, x1, y0, y1, z0, z1));
    if (cube.y0 > y0)
      l.add(new Cuboid(cube.x0, cube.x1, y0, cube.y0 - 1, z0, z1));
    if (cube.y1 < y1)
      l.add(new Cuboid(cube.x0, cube.x1, cube.y1 + 1, y1, z0, z1));
    if (cube.z0 > z0)
      l.add(new Cuboid(cube.x0, cube.x1, cube.y0, cube.y1, z0, cube.z0 - 1));
    if (cube.z1 < z1)
      l.add(new Cuboid(cube.x0, cube.x1, cube.y0, cube.y1, cube.z1 + 1, z1));
    return l;
  }

  boolean smallCube() {
    return -51 < x0 && x0 < 51 && -51 < x1 && x1 < 51;
  }
}
