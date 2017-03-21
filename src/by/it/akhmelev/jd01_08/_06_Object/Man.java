package by.it.akhmelev.jd01_08._06_Object;

class Man {
        private int id;
        private String name;
        private int age;
        public Man (int id, String name, int age){
            this.id = id; this.name = name; this.age = age;
        }
        public int getId() {return id;}
        public String getName() {return name;}
        public int getAge() {return age;}
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            Man other = (Man) obj;
            if (age != other.age) return false;
            if (id != other.id) return false;
            if (name == null) {if (other.name != null) return false;}
                              else if (!name.equals(other.name)) return false;
            return true;
        }
    public int hashCode() {
        return (int)(31 * id + age + ((name == null) ? 0 : name.hashCode()));
    }
    public String toString() {
        return getClass().getName() + "@name" + name + " id:" + id + " age:" + age;
    }


    public static void main(String[] args) {
        Man m1=new Man(0,"Ivanov", 18);
        Man m2=new Man(1,"Ivanov", 19);
        Man m3=new Man(1,"Ivanov", 19);
        if (m1.equals(m2)) System.out.println("m1 equals m2");
        if (m2.equals(m3)) System.out.println("m2 equals m3");
        if (m1.equals(m3)) System.out.println("m1 equals m3");
    }
}