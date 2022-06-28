package InnerClasses;

public class RegularInnerClass {
    private String username;
    private String password;

    class ValidateCredentials{

        public void validate(){
            System.out.println("The username is: " + username);
        }
    }

    public static void main(String[] args) {
        RegularInnerClass run = new RegularInnerClass();
        RegularInnerClass.ValidateCredentials runner = run.new ValidateCredentials();
        runner.validate();
    }
}
