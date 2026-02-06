class PasswordException extends Exception {
    public PasswordException(String message) {
        super(message);
    }
}

public class Main {
    
    static void checkPassword(String password) throws PasswordException {
        if (password.length() < 10) { 
            throw new PasswordException("Password must be at least 10 characters long");
        } else {
            System.out.println("Password is valid");
        }
    }
    
    public static void main(String[] args) {
        try {
            checkPassword("charliekirk_onesmirkandyougetkirkeddildo123");
        } catch (PasswordException e) {
            System.out.println("User-Defined Exception: " + e.getMessage());
        }
    }
}
