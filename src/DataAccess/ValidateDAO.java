package DataAccess;

import common.Library;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ValidateDAO {

    private static ValidateDAO instance = null;
    Library l;

    private final String PHONE_VALID = "^[0-9]{10}$";
    private final String EMAIL_VALID = "^[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";

    public ValidateDAO() {
        l = new Library();
    }

    public static ValidateDAO Instance() {
        if (instance == null) {
            synchronized (ValidateDAO.class) {
                if (instance == null) {
                    instance = new ValidateDAO();
                }
            }
        }
        return instance;
    }

    public String checkInputPhone() {
        while (true) {
            try {
                String phoneCheck = l.inputString("Phone number: ");
                int checkLetter = Integer.parseInt(phoneCheck);
                if (!phoneCheck.matches(PHONE_VALID)) {
                    System.err.println("Phone number must be 10 digits");
                } else {
                    return phoneCheck;
                }
            } catch (NumberFormatException ex) {
                System.err.println("Phone number must be number");
            }
        }
    }

    public String checkInputDate() {
        while (true) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                String dateCheck = l.inputString("Date: ");
                LocalDate date = LocalDate.parse(dateCheck, formatter);
                return dateCheck;
            } catch (DateTimeParseException e) {
                System.err.println("Date to correct format(dd/MM/yyyy)");
            }
        }
    }

    public String checkInputEmail() {
        while (true) {
            String emailCheck = l.inputString("Email: ");
            if (!emailCheck.matches(EMAIL_VALID)) {
                System.err.println("Email must be correct format");
            } else {
                return emailCheck;
            }
        }
    }

    public void Validate() {
        while (true) {
            String phone = checkInputPhone();
            String email = checkInputEmail();
            String date = checkInputDate();
            if (!l.checkInputYN("Do you want continue?(Y/N): ")) {
                System.exit(0);
            }
        }

    }
}
