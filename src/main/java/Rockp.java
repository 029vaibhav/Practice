import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.StrictMath.pow;

public class Rockp {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int no = in.nextInt();

        for (int i = 0; i < no; i++) {
            int noOfr = in.nextInt();


            List<Rock> rockList = new ArrayList<Rock>();
            for (int j = 0; j < noOfr; j++) {
                int x = in.nextInt();
                int y = in.nextInt();
                int r = in.nextInt();
                rockList.add(new Rock(j, x, y, r));
            }
            int shore_b = in.nextInt();
            int shore_a = in.nextInt();

            for (int j = 0; j < noOfr; j++) {
                Rock rock = rockList.get(j);
                rock.isShoreTouch(shore_a, shore_b);
            }

            solve2(rockList, shore_a, shore_b);
        }


    }

    private static void solve2(List<Rock> rockList, int shore_a, int shore_b) {

        List<Rock> shoreA = new ArrayList<>();
        for (Rock rock : rockList) {
            if (rock.touchShoreA) shoreA.add(rock);
        }

        for (Rock rock : shoreA) {
            for (Rock rock1 : rockList) {
                if (overlap(rock.x, rock.y, rock.r, rock1.x, rock1.y, rock.r))
                    rock.getNeighbers().add(rock1);
            }

        }
        List<Rock> rocks = new ArrayList<>();
        for (Rock rock : shoreA) {
            if (rock.getNeighbers().size() != 0)
                rocks.add(rock);

        }

        for (Rock rock : rocks) {
            List<Rock> neighbers = rock.getNeighbers();
            neg(rock, neighbers);
        }

        for (Rock rock : rocks) {
            rock.getNeighbers().forEach(rock1 -> {

                for (Rock rock2 : rock1.getNeighbers()) {

                }

            });
        }


    }



    public static void solve(List<Rock> rockList, int shore_a, int shore_b) {
        Path path = null;
        for (Rock r : rockList) {
            if (r.touchShoreA && r.touchShoreB) {
                path = new Path(r);
                break;
            }
            if (r.touchShoreA) {
                path = findPath(r, rockList);
                if (path != null) {
                    break;
                }
            }
        }

        System.out.println(path);

    }

    public static Path findPath(final Rock rock, List<Rock> rockList) {

        if (rock.neighbers != null)
            return null;
        for (Rock r : rockList) {
            if (rock.index != r.index && rock.r + r.r - Math.sqrt(Math.pow(rock.y - r.y, 2) + Math.pow(rock.x - r.x, 2)) > 0) {
                if (r.touchShoreB) {
                    //found path
                    Path p = new Path(rock);
                    p.next = new Path(r);
                    return p;
                }
                List<Rock> neighbers = rock.neighbers;
                if (neighbers == null) {
                    neighbers = new ArrayList<Rock>();
                }
                neighbers.add(r);
                rock.neighbers = neighbers;
            }
        }
        for (Rock r : rock.neighbers) {
            Path next = findPath(r, rockList);
            if (next != null) {
                Path p = new Path(rock);
                p.next = next;
                return p;
            }
        }
        return null;
    }

    static boolean overlap(float x1, float y1, float r1, float x2, float y2, float r2) {
        if ((pow((x2 - x1), 2) + pow((y2 - y1), 2)) < (r1 + r2))
            return true;
        else
            return false;
    }

    static void neg(Rock rock, List<Rock> rockList) {
        for (Rock rock1 : rockList) {
            if (overlap(rock.x, rock.y, rock.r, rock1.x, rock1.y, rock.r))
                rock.getNeighbers().add(rock1);
        }

    }

    boolean ShoreRock(float rockX, float rockY, float rockR, float yIntercept) {
        if (((rockY - yIntercept) - rockR) > 0)
            return true;
        else
            return false;
    }
}

class Path {
    Rock r;
    Path next;

    Path(Rock r) {
        this.r = r;
    }

    @Override
    public String toString() {
        if (r == null)
            return "-1";
        int count = 1;
        Path temp = next;
        while (temp != null) {
            temp = temp.next;
            count++;
        }

        return "" + count;
    }
}

class Rock {
    int index;
    int x;
    int y;
    int r;
    boolean touchShoreA = false;
    boolean touchShoreB = false;
    // neighbersClosertoShore, y + r bigger or equals this
    List<Rock> neighbers = new ArrayList<>();

    Rock(int index, int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.index = index;

    }

    public List<Rock> getNeighbers() {
        return neighbers;
    }

    public void setNeighbers(List<Rock> neighbers) {
        this.neighbers = neighbers;
    }

    void isShoreTouch(int shore_a, int shore_b) {
        this.touchShoreA = (Math.abs(y - r) <= r);
        this.touchShoreB = (Math.abs(shore_b - y) <= r);
    }

}
