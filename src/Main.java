public class Main {

    public static void main(String[] args) {
	    AnyList list = new AnyList();

	    list.add(5);
	    int intVal = list.getLast();
        System.out.println("Value: " + intVal);

        list.add("Some String");
	    String strVal = list.getLast();
        System.out.println("Value: " + strVal);

	    list.add(124L);
        Long longVal = list.getLast();
        System.out.println("Value: " + longVal);
    }
}
