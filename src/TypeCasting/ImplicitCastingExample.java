package TypeCasting;

public class ImplicitCastingExample{   //also know as Widen casting
    public static void main(String[] args){
        int i = 200;

        //automatic type conversation to long
        long l = i;

        //automatic type conversation to float
        float f = l;

        System.out.println(i + " is of type " + ((Object)i).getClass().getSimpleName());
        System.out.println(l + " is of type " + ((Object)l).getClass().getSimpleName());
        System.out.println(f + " is of type " + ((Object)f).getClass().getSimpleName());
    }
}
