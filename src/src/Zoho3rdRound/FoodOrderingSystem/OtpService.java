package src.Zoho3rdRound.FoodOrderingSystem;

import java.util.Random;
import java.util.concurrent.TimeUnit;

// Simple service to generate and validate OTPs
public class OtpService {
    private static final Random random = new Random();
    private static final int OTP_LENGTH = 6; // Standard OTP length

    public static String generateOtp() {
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < OTP_LENGTH; i++) {
            otp.append(random.nextInt(10)); // Append random digit (0-9)
        }
        return otp.toString();
    }

    // Simulate sending OTP (just prints it for console app)
    public static void sendOtp(String phoneNumber, String otp) {
        System.out.println("--------------------------------------------------");
        System.out.printf("SIMULATING OTP SEND to %s: Your OTP is %s\n", phoneNumber, otp);
        System.out.println("--------------------------------------------------");
        // In a real app, this would involve an SMS gateway API call
    }
}
