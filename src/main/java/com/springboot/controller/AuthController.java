package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.springboot.jparepository.FamiyRepository;
import com.springboot.jparepository.IndividualPolicyRepository;
import com.springboot.jparepository.UserRepository;
import com.springboot.model.FamilyPolicy;
import com.springboot.model.IndividualPolicy;
import com.springboot.model.User;

@CrossOrigin("*")
@RestController
public class AuthController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private IndividualPolicyRepository policyRepository;

	@Autowired
	private FamiyRepository familyService;

	@PostMapping("/individual-api")
	public ResponseEntity<String> addPolicy(@RequestBody IndividualPolicy policy) {
		try {
			IndividualPolicy savedPolicy = policyRepository.save(policy);
			return new ResponseEntity<>("Policy added with ID: " + savedPolicy.getPolicyHolderId(), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to add policy", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/family-members")
	public ResponseEntity<String> addFamilyMember(@RequestBody FamilyPolicy familyMember) {
		familyService.save(familyMember);
		return new ResponseEntity<>("Family member added successfully", HttpStatus.CREATED);
	}

	@GetMapping("/family-members")
	public List<FamilyPolicy> getAllFamilyMembers() {
		return familyService.findAll();
	}

	@DeleteMapping("/delete-members/{id}")
	public ResponseEntity<Void> deleteFamilyMember(@PathVariable Long id) {
		try {
			familyService.deleteById(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

//	@PostMapping("/register")
//	public String register(@RequestBody User user) {
////		User existingUser = userRepository.findByEmail(user.getEmail());
////		System.out.println(existingUser);
////		if(existingUser!=null) {
//		userRepository.save(user);
////		}
//		return "Registration successful";
//	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user) {
		// Check if the email already exists in the database
		User existingUser = userRepository.findByEmail(user.getEmail());
		if (existingUser != null) {
			// Email already registered, return error response
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already registered");
		} else {
			// Email not found, proceed with registration
			userRepository.save(user);
			return ResponseEntity.ok("Registration successful");
		}
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user) {
		User existingUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if (existingUser != null) {
			return ResponseEntity.ok("Success");
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error");
		}
	}

	@PostMapping("/recover-password")
	public ResponseEntity<String> recoverPassword(@RequestBody User user) {
		User existingUser = userRepository.findByEmail(user.getEmail());
		if (existingUser != null) {
			// Implement your password recovery logic here
			// For demonstration purposes, let's assume you want to return email and
			// password
			String response = "Email: " + existingUser.getEmail() + ", Password: " + existingUser.getPassword();
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found. Password recovery failed");
		}
	}

	// Store generated OTPs temporarily (in-memory map)
//    private Map<String, String> otpMap = new HashMap<>();

//    @PostMapping("/send-otp")
//    public ResponseEntity<String> sendOTP(@RequestBody Map<String, String> requestBody) {
//        String mobileNo = requestBody.get("mobileNo");
//
//        // Generate OTP (6-digit random number)
//        String otp = generateOTP();
//
//        // Simulate sending OTP via SMS (replace this with actual SMS sending logic)
//        // For demonstration, just print OTP to console
//        System.out.println("OTP for " + mobileNo + ": " + otp);
//
//        // Store OTP in map for verification later
//        otpMap.put(mobileNo, otp);
//
//        return ResponseEntity.ok("OTP sent successfully");
//    }
//
//    @PostMapping("/verify-otp")
//    public ResponseEntity<String> verifyOTP(@RequestBody Map<String, String> requestBody) {
//        String mobileNo = requestBody.get("mobileNo");
//        String enteredOTP = requestBody.get("otp");
//
//        // Get OTP from map based on mobile number
//        String generatedOTP = otpMap.get(mobileNo);
//
//        if (generatedOTP != null && generatedOTP.equals(enteredOTP)) {
//            // OTP matched, clear OTP from map and proceed with registration or login
//            otpMap.remove(mobileNo);
//            return ResponseEntity.ok("OTP verified successfully");
//        } else {
//            // OTP didn't match, return error response
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid OTP");
//        }
//    }
//
//	private String generateOTP() {
//		// Generate a random 6-digit OTP
//		Random random = new Random();
//		int otp = 100000 + random.nextInt(900000);
//		return String.valueOf(otp);
//	}

}
