package src.Zoho3rdRound.FoodOrderingSystem;

import java.util.Map;

public class UserService {

    // Corresponds to: verify_user(phoneNumber, otp)
    public boolean verifyRegistrationOtp(String phoneNumber, String otp) {
        String storedOtp = DataStore.registrationOtps.get(phoneNumber);
        if (storedOtp != null && storedOtp.equals(otp)) {
            DataStore.registrationOtps.remove(phoneNumber); // OTP used, remove it
            return true;
        }
        return false;
    }

    // Corresponds to: register_user(phoneNumber, userName, emailAddress, address)
    // Assumes verifyRegistrationOtp was called and returned true before this
    public User registerUser(String phoneNumber, String userName, String emailAddress, String address) {
        if (DataStore.usersByPhoneNumber.containsKey(phoneNumber)) {
            System.out.println("Error: Phone number already registered.");
            return null;
        }
        User newUser = new User(phoneNumber, userName, emailAddress, address);
        DataStore.usersByPhoneNumber.put(phoneNumber, newUser);
        DataStore.usersById.put(newUser.getUserId(), newUser);
        System.out.println("User registered successfully: " + newUser.getUserName());
        return newUser;
    }

    // Corresponds to: generate_login_otp(phoneNumber)
    public boolean generateLoginOtp(String phoneNumber) {
        if (!DataStore.usersByPhoneNumber.containsKey(phoneNumber)) {
            System.out.println("Error: Phone number not registered.");
            return false;
        }
        String otp = OtpService.generateOtp();
        DataStore.loginOtps.put(phoneNumber, otp);
        OtpService.sendOtp(phoneNumber, otp); // Simulate sending
        // Add OTP expiry logic here in a real system
        return true;
    }

    // Corresponds to: login(phoneNumber, otp)
    public User loginUser(String phoneNumber, String otp) {
        String storedOtp = DataStore.loginOtps.get(phoneNumber);
        User user = DataStore.usersByPhoneNumber.get(phoneNumber);

        if (user != null && storedOtp != null && storedOtp.equals(otp)) {
            DataStore.loginOtps.remove(phoneNumber); // OTP used
            System.out.println("Login successful! Welcome " + user.getUserName());
            return user;
        } else {
            System.out.println("Error: Invalid phone number or OTP.");
            return null;
        }
    }
}