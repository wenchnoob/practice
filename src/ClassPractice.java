public class ClassPractice {

    public static void main(String[] args) {
        Hey h = new Hey();
        System.out.println(h.getName());
        System.out.println(h.getName());
    }

    // class to represent circle
    static class Circle implements Comparable<Circle> {
        public static final double PI = 3.14;
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double area() {
            return Circle.PI * Math.pow(radius, 2);
        }

        @Override
        public int compareTo(Circle o) {
            double diff =  this.radius - o.radius;
            if (diff < 0) return -1;
            else if (diff > 0) return 1;
            else return 0;
        }
    }


    static class Hey {



        public Hey() {}

        public String getName() {
            return "Healdjkf;lajsdy";
        }
    }
}
