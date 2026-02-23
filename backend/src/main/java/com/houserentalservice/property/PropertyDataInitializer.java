package com.houserentalservice.property;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
public class PropertyDataInitializer implements CommandLineRunner {

    private final PropertyRepository propertyRepository;

    public PropertyDataInitializer(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public void run(String... args) {
        if (propertyRepository.count() == 0) {
            initializeProperties();
        }
    }

    private void initializeProperties() {
        // Mumbai Properties
        createProperty("Modern 2BHK Apartment", "Mumbai", "Bandra", 
            new BigDecimal(55000), 2, 2, 1100, "apartment", true,
            "Beautiful apartment in Bandra with sea view. Perfect for professionals.",
            "https://images.pexels.com/photos/439391/pexels-photo-439391.jpeg?auto=compress&cs=tinysrgb&w=1200",
            8, 12, 1, true, true, true, "West", 2,
            Arrays.asList("WiFi", "AC", "Swimming Pool", "Gym", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("Beach - 500m", "Metro Station - 800m", "Shopping Mall - 1.2km"));

        createProperty("Luxury 3BHK Sea View", "Mumbai", "Worli",
            new BigDecimal(85000), 3, 3, 1800, "apartment", true,
            "Premium 3BHK with stunning sea view and modern amenities in Worli.",
            "https://images.pexels.com/photos/1571460/pexels-photo-1571460.jpeg?auto=compress&cs=tinysrgb&w=1200",
            12, 20, 2, true, true, true, "West", 1,
            Arrays.asList("WiFi", "AC", "Swimming Pool", "Gym", "Parking", "24/7 Security", "Power Backup", "Concierge"),
            Arrays.asList("Sea Face - 200m", "Metro Station - 500m", "Shopping Mall - 800m"));

        createProperty("Cozy 1BHK Studio", "Mumbai", "Powai",
            new BigDecimal(35000), 1, 1, 600, "apartment", true,
            "Compact and well-designed studio apartment in Powai, ideal for working professionals.",
            "https://images.pexels.com/photos/1457842/pexels-photo-1457842.jpeg?auto=compress&cs=tinysrgb&w=1200",
            4, 10, 1, true, true, true, "East", 3,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security"),
            Arrays.asList("IT Park - 1km", "Lake - 500m", "Shopping Mall - 1.5km"));

        createProperty("Spacious 3BHK Flat", "Mumbai", "Andheri",
            new BigDecimal(45000), 3, 3, 1450, "apartment", true,
            "Well-maintained 3BHK in Andheri West with excellent connectivity.",
            "https://images.pexels.com/photos/271643/pexels-photo-271643.jpeg?auto=compress&cs=tinysrgb&w=1200",
            5, 15, 2, true, true, true, "North", 4,
            Arrays.asList("WiFi", "AC", "Modular Kitchen", "Parking", "24/7 Security"),
            Arrays.asList("Airport - 3km", "Metro Station - 600m", "Hospital - 1.5km"));

        createProperty("Luxury 4BHK Villa", "Mumbai", "Juhu",
            new BigDecimal(120000), 4, 4, 2800, "villa", true,
            "Premium villa with private garden and modern amenities.",
            "https://images.pexels.com/photos/2102587/pexels-photo-2102587.jpeg?auto=compress&cs=tinysrgb&w=1200",
            1, 2, 3, false, true, true, "South", 1,
            Arrays.asList("WiFi", "AC", "Swimming Pool", "Garden", "Gym", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("Beach - 200m", "Shopping Complex - 800m", "School - 1km"));

        createProperty("Elegant 2BHK Apartment", "Mumbai", "Andheri",
            new BigDecimal(48000), 2, 2, 1150, "apartment", true,
            "Well-furnished 2BHK in Andheri West with excellent connectivity to airport and metro.",
            "https://images.pexels.com/photos/1396122/pexels-photo-1396122.jpeg?auto=compress&cs=tinysrgb&w=1200",
            6, 14, 1, true, true, true, "North", 2,
            Arrays.asList("WiFi", "AC", "Modular Kitchen", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("Airport - 2.5km", "Metro Station - 400m", "Hospital - 1.2km"));

        // Bangalore Properties
        createProperty("2BHK Apartment in Koramangala", "Bangalore", "Koramangala",
            new BigDecimal(42000), 2, 2, 980, "apartment", true,
            "Modern apartment in Koramangala, close to IT hubs and restaurants.",
            "https://images.pexels.com/photos/439391/pexels-photo-439391.jpeg?auto=compress&cs=tinysrgb&w=1200",
            5, 12, 1, true, true, true, "East", 3,
            Arrays.asList("WiFi", "AC", "Swimming Pool", "Gym", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("Metro Station - 800m", "Shopping Mall - 1.5km", "Hospital - 2km", "School - 1.2km"));

        createProperty("Premium 3BHK Flat", "Bangalore", "Indiranagar",
            new BigDecimal(55000), 3, 3, 1700, "apartment", true,
            "Spacious 3BHK in prime Indiranagar location with modern interiors and amenities.",
            "https://images.pexels.com/photos/1571468/pexels-photo-1571468.jpeg?auto=compress&cs=tinysrgb&w=1200",
            7, 15, 2, true, true, true, "South", 2,
            Arrays.asList("WiFi", "AC", "Swimming Pool", "Gym", "Parking", "24/7 Security", "Power Backup", "Modular Kitchen"),
            Arrays.asList("Metro Station - 600m", "Shopping Mall - 1km", "Hospital - 1.5km", "School - 800m"));

        createProperty("Modern 4BHK Villa", "Bangalore", "Whitefield",
            new BigDecimal(95000), 4, 4, 2400, "villa", true,
            "Luxury villa in Whitefield with private garden and premium finishes.",
            "https://images.pexels.com/photos/280222/pexels-photo-280222.jpeg?auto=compress&cs=tinysrgb&w=1200",
            1, 2, 3, false, true, true, "North", 1,
            Arrays.asList("WiFi", "AC", "Swimming Pool", "Garden", "Gym", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("IT Park - 1.5km", "Shopping Mall - 2km", "School - 1km"));

        createProperty("Compact 1BHK Studio", "Bangalore", "Electronic City",
            new BigDecimal(22000), 1, 1, 580, "apartment", true,
            "Affordable studio apartment perfect for IT professionals working in Electronic City.",
            "https://images.pexels.com/photos/1454806/pexels-photo-1454806.jpeg?auto=compress&cs=tinysrgb&w=1200",
            2, 8, 1, true, true, true, "East", 4,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security"),
            Arrays.asList("IT Park - 500m", "Metro Station - 1.5km", "Shopping Mall - 2km"));

        createProperty("3BHK Independent House", "Bangalore", "Indiranagar",
            new BigDecimal(50000), 3, 3, 1650, "house", false,
            "Spacious independent house in Indiranagar with garden.",
            "https://images.pexels.com/photos/32870/pexels-photo.jpg?auto=compress&cs=tinysrgb&w=1200",
            2, 3, 2, false, true, true, "North", 5,
            Arrays.asList("WiFi", "Water Supply", "Electricity", "Garden", "Parking", "Security"),
            Arrays.asList("Metro Station - 1km", "Supermarket - 800m", "School - 600m"));

        createProperty("1BHK Studio Apartment", "Bangalore", "HSR Layout",
            new BigDecimal(25000), 1, 1, 650, "apartment", true,
            "Compact and well-furnished studio apartment for singles or couples.",
            "https://images.pexels.com/photos/271643/pexels-photo-271643.jpeg?auto=compress&cs=tinysrgb&w=1200",
            3, 8, 1, true, true, true, "South", 2,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security"),
            Arrays.asList("Metro Station - 1.2km", "Shopping Mall - 2km"));

        // Delhi Properties
        createProperty("2BHK Flat in Dwarka", "Delhi", "Dwarka",
            new BigDecimal(35000), 2, 2, 1050, "apartment", true,
            "Well-connected 2BHK in Dwarka with metro connectivity.",
            "https://images.pexels.com/photos/439391/pexels-photo-439391.jpeg?auto=compress&cs=tinysrgb&w=1200",
            6, 14, 1, true, true, true, "East", 4,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("Metro Station - 300m", "Shopping Mall - 1km", "Hospital - 2km"));

        createProperty("Spacious 3BHK Apartment", "Delhi", "Gurgaon",
            new BigDecimal(60000), 3, 3, 1600, "apartment", true,
            "Modern 3BHK in Gurgaon Sector with excellent connectivity and amenities.",
            "https://images.pexels.com/photos/1396132/pexels-photo-1396132.jpeg?auto=compress&cs=tinysrgb&w=1200",
            8, 16, 2, true, true, true, "South", 2,
            Arrays.asList("WiFi", "AC", "Swimming Pool", "Gym", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("Metro Station - 700m", "Shopping Mall - 1.2km", "Hospital - 1.8km"));

        createProperty("Luxury 5BHK Penthouse", "Delhi", "Noida",
            new BigDecimal(125000), 5, 5, 3200, "apartment", true,
            "Ultra-luxury penthouse in Noida with panoramic city views and premium amenities.",
            "https://images.pexels.com/photos/1571453/pexels-photo-1571453.jpeg?auto=compress&cs=tinysrgb&w=1200",
            18, 20, 3, true, true, true, "West", 1,
            Arrays.asList("WiFi", "AC", "Swimming Pool", "Gym", "Parking", "24/7 Security", "Power Backup", "Concierge", "Rooftop Garden"),
            Arrays.asList("Metro Station - 500m", "Shopping Mall - 800m", "Hospital - 1km", "School - 1.2km"));

        createProperty("Cozy 1BHK Flat", "Delhi", "Connaught Place",
            new BigDecimal(40000), 1, 1, 650, "apartment", true,
            "Well-located 1BHK in the heart of Connaught Place, perfect for professionals.",
            "https://images.pexels.com/photos/1454805/pexels-photo-1454805.jpeg?auto=compress&cs=tinysrgb&w=1200",
            4, 10, 1, true, true, true, "North", 5,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security"),
            Arrays.asList("Metro Station - 200m", "Shopping Mall - 300m", "Hospital - 1km"));

        createProperty("4BHK Luxury Apartment", "Delhi", "Saket",
            new BigDecimal(75000), 4, 4, 2200, "apartment", true,
            "Premium 4BHK apartment in Saket with all modern amenities.",
            "https://images.pexels.com/photos/2102587/pexels-photo-2102587.jpeg?auto=compress&cs=tinysrgb&w=1200",
            10, 18, 2, true, true, true, "West", 1,
            Arrays.asList("WiFi", "AC", "Swimming Pool", "Gym", "Parking", "24/7 Security", "Power Backup", "Modular Kitchen"),
            Arrays.asList("Metro Station - 500m", "Shopping Mall - 800m", "Hospital - 1.5km"));

        // Pune Properties
        createProperty("3BHK Apartment in Hinjewadi", "Pune", "Hinjewadi",
            new BigDecimal(38000), 3, 3, 1500, "apartment", false,
            "Spacious 3BHK near IT parks, ideal for working professionals.",
            "https://images.pexels.com/photos/32870/pexels-photo.jpg?auto=compress&cs=tinysrgb&w=1200",
            4, 10, 2, true, true, true, "North", 3,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("IT Park - 2km", "Supermarket - 1km", "School - 800m"));

        createProperty("2BHK Flat in Kothrud", "Pune", "Kothrud",
            new BigDecimal(32000), 2, 2, 950, "apartment", true,
            "Furnished 2BHK in peaceful Kothrud area.",
            "https://images.pexels.com/photos/271643/pexels-photo-271643.jpeg?auto=compress&cs=tinysrgb&w=1200",
            3, 7, 1, true, true, true, "East", 5,
            Arrays.asList("WiFi", "AC", "Parking", "Security"),
            Arrays.asList("Metro Station - 1.5km", "Shopping Mall - 2km"));

        // Hyderabad Properties
        createProperty("2BHK in Hitech City", "Hyderabad", "Hitech City",
            new BigDecimal(40000), 2, 2, 1100, "apartment", true,
            "Modern apartment in Hitech City, close to IT companies.",
            "https://images.pexels.com/photos/439391/pexels-photo-439391.jpeg?auto=compress&cs=tinysrgb&w=1200",
            7, 15, 1, true, true, true, "South", 2,
            Arrays.asList("WiFi", "AC", "Swimming Pool", "Gym", "Parking", "24/7 Security"),
            Arrays.asList("IT Park - 1km", "Shopping Mall - 1.5km", "Metro Station - 800m"));

        createProperty("3BHK Villa in Gachibowli", "Hyderabad", "Gachibowli",
            new BigDecimal(65000), 3, 3, 1800, "villa", true,
            "Beautiful villa with private garden in Gachibowli.",
            "https://images.pexels.com/photos/2102587/pexels-photo-2102587.jpeg?auto=compress&cs=tinysrgb&w=1200",
            1, 2, 2, false, true, true, "North", 3,
            Arrays.asList("WiFi", "AC", "Garden", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("IT Park - 2km", "Shopping Mall - 1.2km", "School - 1km"));

        // Chennai Properties
        createProperty("2BHK Apartment in T Nagar", "Chennai", "T Nagar",
            new BigDecimal(35000), 2, 2, 1000, "apartment", true,
            "Well-located apartment in T Nagar with excellent connectivity.",
            "https://images.pexels.com/photos/271643/pexels-photo-271643.jpeg?auto=compress&cs=tinysrgb&w=1200",
            5, 12, 1, true, true, true, "East", 4,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security"),
            Arrays.asList("Metro Station - 600m", "Shopping Mall - 500m", "Hospital - 1.5km"));

        // Kolkata Properties
        createProperty("3BHK Flat in Salt Lake", "Kolkata", "Salt Lake",
            new BigDecimal(42000), 3, 3, 1400, "apartment", false,
            "Spacious 3BHK in Salt Lake, perfect for families.",
            "https://images.pexels.com/photos/32870/pexels-photo.jpg?auto=compress&cs=tinysrgb&w=1200",
            4, 10, 2, true, true, true, "North", 5,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("Metro Station - 1km", "Shopping Mall - 1.5km", "School - 800m"));

        // Ahmedabad Properties
        createProperty("2BHK Apartment in Prahlad Nagar", "Ahmedabad", "Prahlad Nagar",
            new BigDecimal(28000), 2, 2, 950, "apartment", true,
            "Modern apartment in Prahlad Nagar with good amenities.",
            "https://images.pexels.com/photos/439391/pexels-photo-439391.jpeg?auto=compress&cs=tinysrgb&w=1200",
            6, 12, 1, true, true, true, "West", 3,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security"),
            Arrays.asList("Shopping Mall - 1km", "Hospital - 2km", "School - 1.5km"));

        // Jaipur Properties
        createProperty("3BHK House in Malviya Nagar", "Jaipur", "Malviya Nagar",
            new BigDecimal(30000), 3, 3, 1600, "house", false,
            "Independent house in Malviya Nagar with garden.",
            "https://images.pexels.com/photos/32870/pexels-photo.jpg?auto=compress&cs=tinysrgb&w=1200",
            2, 3, 2, false, true, true, "South", 6,
            Arrays.asList("WiFi", "Water Supply", "Electricity", "Garden", "Parking"),
            Arrays.asList("Shopping Mall - 1.2km", "Hospital - 2km", "School - 1km"));

        // Surat Properties
        createProperty("2BHK Flat in Vesu", "Surat", "Vesu",
            new BigDecimal(25000), 2, 2, 900, "apartment", true,
            "Furnished 2BHK in Vesu, Surat's premium area.",
            "https://images.pexels.com/photos/271643/pexels-photo-271643.jpeg?auto=compress&cs=tinysrgb&w=1200",
            4, 10, 1, true, true, true, "East", 2,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security"),
            Arrays.asList("Shopping Mall - 800m", "Hospital - 1.5km"));

        // Lucknow Properties
        createProperty("3BHK Apartment in Gomti Nagar", "Lucknow", "Gomti Nagar",
            new BigDecimal(32000), 3, 3, 1450, "apartment", false,
            "Spacious 3BHK in Gomti Nagar with excellent connectivity.",
            "https://images.pexels.com/photos/439391/pexels-photo-439391.jpeg?auto=compress&cs=tinysrgb&w=1200",
            5, 12, 2, true, true, true, "North", 4,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("Shopping Mall - 1km", "Hospital - 2km", "School - 1.2km"));

        // Coimbatore Properties
        createProperty("2BHK in RS Puram", "Coimbatore", "RS Puram",
            new BigDecimal(22000), 2, 2, 1000, "apartment", true,
            "Well-maintained 2BHK in RS Puram, Coimbatore.",
            "https://images.pexels.com/photos/271643/pexels-photo-271643.jpeg?auto=compress&cs=tinysrgb&w=1200",
            3, 8, 1, true, true, true, "South", 5,
            Arrays.asList("WiFi", "AC", "Parking", "Security"),
            Arrays.asList("Shopping Mall - 1.5km", "Hospital - 2km"));

        // Additional Properties for more variety
        createProperty("Modern 2BHK Apartment", "Pune", "Viman Nagar",
            new BigDecimal(38000), 2, 2, 1100, "apartment", true,
            "Contemporary 2BHK in Viman Nagar with excellent connectivity to airport and IT parks.",
            "https://images.pexels.com/photos/1396132/pexels-photo-1396132.jpeg?auto=compress&cs=tinysrgb&w=1200",
            5, 12, 1, true, true, true, "East", 2,
            Arrays.asList("WiFi", "AC", "Swimming Pool", "Gym", "Parking", "24/7 Security"),
            Arrays.asList("Airport - 3km", "IT Park - 2km", "Shopping Mall - 1.5km"));

        createProperty("Spacious 3BHK House", "Pune", "Baner",
            new BigDecimal(45000), 3, 3, 1750, "house", false,
            "Independent 3BHK house in Baner with garden and parking.",
            "https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&w=1200",
            1, 2, 2, false, true, true, "North", 6,
            Arrays.asList("WiFi", "Water Supply", "Electricity", "Garden", "Parking", "Security"),
            Arrays.asList("IT Park - 1.5km", "Shopping Mall - 2km", "School - 1km"));

        createProperty("Luxury 3BHK Apartment", "Hyderabad", "Banjara Hills",
            new BigDecimal(65000), 3, 3, 1900, "apartment", true,
            "Premium 3BHK in Banjara Hills with luxury amenities and city views.",
            "https://images.pexels.com/photos/1571460/pexels-photo-1571460.jpeg?auto=compress&cs=tinysrgb&w=1200",
            10, 18, 2, true, true, true, "West", 1,
            Arrays.asList("WiFi", "AC", "Swimming Pool", "Gym", "Parking", "24/7 Security", "Power Backup", "Concierge"),
            Arrays.asList("Shopping Mall - 800m", "Hospital - 1km", "School - 1.2km"));

        createProperty("Affordable 2BHK Flat", "Hyderabad", "Kondapur",
            new BigDecimal(32000), 2, 2, 950, "apartment", false,
            "Budget-friendly 2BHK in Kondapur, ideal for families.",
            "https://images.pexels.com/photos/1396122/pexels-photo-1396122.jpeg?auto=compress&cs=tinysrgb&w=1200",
            3, 9, 1, true, true, true, "South", 4,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security"),
            Arrays.asList("IT Park - 1km", "Shopping Mall - 1.5km", "School - 800m"));

        createProperty("Premium 4BHK Apartment", "Chennai", "OMR",
            new BigDecimal(70000), 4, 4, 2100, "apartment", true,
            "Luxury 4BHK on OMR with modern amenities and excellent connectivity.",
            "https://images.pexels.com/photos/1571453/pexels-photo-1571453.jpeg?auto=compress&cs=tinysrgb&w=1200",
            9, 16, 2, true, true, true, "East", 2,
            Arrays.asList("WiFi", "AC", "Swimming Pool", "Gym", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("IT Park - 2km", "Shopping Mall - 1.5km", "Hospital - 2km", "School - 1.5km"));

        createProperty("Modern 2BHK Flat", "Chennai", "Adyar",
            new BigDecimal(40000), 2, 2, 1100, "apartment", true,
            "Well-designed 2BHK in Adyar with sea breeze and modern amenities.",
            "https://images.pexels.com/photos/1454806/pexels-photo-1454806.jpeg?auto=compress&cs=tinysrgb&w=1200",
            6, 12, 1, true, true, true, "East", 3,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("Beach - 1km", "Shopping Mall - 1.2km", "Hospital - 1.5km"));

        createProperty("Elegant 3BHK Apartment", "Kolkata", "Park Street",
            new BigDecimal(45000), 3, 3, 1500, "apartment", true,
            "Charming 3BHK in Park Street area with heritage charm and modern amenities.",
            "https://images.pexels.com/photos/1396122/pexels-photo-1396122.jpeg?auto=compress&cs=tinysrgb&w=1200",
            5, 11, 2, true, true, true, "North", 5,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("Metro Station - 500m", "Shopping Mall - 800m", "Hospital - 1km"));

        createProperty("Modern 2BHK Flat", "Kolkata", "New Town",
            new BigDecimal(35000), 2, 2, 1050, "apartment", false,
            "Contemporary 2BHK in New Town with excellent infrastructure.",
            "https://images.pexels.com/photos/1454805/pexels-photo-1454805.jpeg?auto=compress&cs=tinysrgb&w=1200",
            4, 10, 1, true, true, true, "South", 3,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security"),
            Arrays.asList("Metro Station - 1km", "Shopping Mall - 1.5km", "School - 1.2km"));

        createProperty("Luxury 3BHK Villa", "Ahmedabad", "Satellite",
            new BigDecimal(55000), 3, 3, 2000, "villa", true,
            "Beautiful villa in Satellite area with private garden and modern amenities.",
            "https://images.pexels.com/photos/280222/pexels-photo-280222.jpeg?auto=compress&cs=tinysrgb&w=1200",
            1, 2, 2, false, true, true, "West", 2,
            Arrays.asList("WiFi", "AC", "Garden", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("Shopping Mall - 1km", "Hospital - 1.5km", "School - 1km"));

        createProperty("Modern 2BHK Apartment", "Ahmedabad", "Vastrapur",
            new BigDecimal(30000), 2, 2, 1000, "apartment", true,
            "Well-furnished 2BHK in Vastrapur with good connectivity.",
            "https://images.pexels.com/photos/1396132/pexels-photo-1396132.jpeg?auto=compress&cs=tinysrgb&w=1200",
            5, 12, 1, true, true, true, "East", 4,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security"),
            Arrays.asList("Lake - 500m", "Shopping Mall - 1.2km", "Hospital - 2km"));

        createProperty("Spacious 4BHK House", "Jaipur", "Vaishali Nagar",
            new BigDecimal(45000), 4, 4, 2200, "house", false,
            "Large independent house in Vaishali Nagar with garden and parking.",
            "https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg?auto=compress&cs=tinysrgb&w=1200",
            1, 2, 3, false, true, true, "North", 7,
            Arrays.asList("WiFi", "Water Supply", "Electricity", "Garden", "Parking", "Security"),
            Arrays.asList("Shopping Mall - 1.5km", "Hospital - 2km", "School - 1.2km"));

        createProperty("Modern 2BHK Flat", "Jaipur", "C-Scheme",
            new BigDecimal(32000), 2, 2, 980, "apartment", true,
            "Contemporary 2BHK in C-Scheme, Jaipur's prime commercial area.",
            "https://images.pexels.com/photos/1454806/pexels-photo-1454806.jpeg?auto=compress&cs=tinysrgb&w=1200",
            4, 10, 1, true, true, true, "South", 3,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security"),
            Arrays.asList("Shopping Mall - 800m", "Hospital - 1.5km", "School - 1km"));

        createProperty("Premium 3BHK Apartment", "Surat", "Adajan",
            new BigDecimal(42000), 3, 3, 1600, "apartment", true,
            "Luxury 3BHK in Adajan with modern amenities and river view.",
            "https://images.pexels.com/photos/1571468/pexels-photo-1571468.jpeg?auto=compress&cs=tinysrgb&w=1200",
            7, 14, 2, true, true, true, "West", 2,
            Arrays.asList("WiFi", "AC", "Swimming Pool", "Gym", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("River - 500m", "Shopping Mall - 1km", "Hospital - 1.5km"));

        createProperty("Affordable 2BHK Flat", "Nagpur", "Civil Lines",
            new BigDecimal(25000), 2, 2, 950, "apartment", false,
            "Budget-friendly 2BHK in Civil Lines, Nagpur.",
            "https://images.pexels.com/photos/1454805/pexels-photo-1454805.jpeg?auto=compress&cs=tinysrgb&w=1200",
            3, 8, 1, true, true, true, "East", 5,
            Arrays.asList("WiFi", "AC", "Parking", "Security"),
            Arrays.asList("Shopping Mall - 1.2km", "Hospital - 1.8km", "School - 1km"));

        createProperty("Modern 3BHK Apartment", "Nagpur", "Dharampeth",
            new BigDecimal(35000), 3, 3, 1450, "apartment", true,
            "Well-maintained 3BHK in Dharampeth with good amenities.",
            "https://images.pexels.com/photos/1396122/pexels-photo-1396122.jpeg?auto=compress&cs=tinysrgb&w=1200",
            5, 11, 2, true, true, true, "North", 4,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("Shopping Mall - 1km", "Hospital - 1.5km", "School - 800m"));

        createProperty("Luxury 4BHK Villa", "Indore", "Vijay Nagar",
            new BigDecimal(60000), 4, 4, 2500, "villa", true,
            "Premium villa in Vijay Nagar with private garden and modern amenities.",
            "https://images.pexels.com/photos/2102587/pexels-photo-2102587.jpeg?auto=compress&cs=tinysrgb&w=1200",
            1, 2, 3, false, true, true, "South", 1,
            Arrays.asList("WiFi", "AC", "Swimming Pool", "Garden", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("Shopping Mall - 1.5km", "Hospital - 2km", "School - 1.2km"));

        createProperty("Modern 2BHK Flat", "Indore", "New Palasia",
            new BigDecimal(28000), 2, 2, 1000, "apartment", true,
            "Contemporary 2BHK in New Palasia with excellent connectivity.",
            "https://images.pexels.com/photos/1454806/pexels-photo-1454806.jpeg?auto=compress&cs=tinysrgb&w=1200",
            4, 10, 1, true, true, true, "East", 3,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security"),
            Arrays.asList("Shopping Mall - 800m", "Hospital - 1.5km", "School - 1km"));

        createProperty("Premium 3BHK Apartment", "Chandigarh", "Sector 17",
            new BigDecimal(50000), 3, 3, 1700, "apartment", true,
            "Luxury 3BHK in Sector 17, Chandigarh's prime location.",
            "https://images.pexels.com/photos/1571460/pexels-photo-1571460.jpeg?auto=compress&cs=tinysrgb&w=1200",
            6, 12, 2, true, true, true, "North", 2,
            Arrays.asList("WiFi", "AC", "Swimming Pool", "Gym", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("Shopping Mall - 500m", "Hospital - 1km", "School - 800m"));

        createProperty("Modern 2BHK Flat", "Chandigarh", "Sector 22",
            new BigDecimal(38000), 2, 2, 1100, "apartment", false,
            "Well-designed 2BHK in Sector 22 with good amenities.",
            "https://images.pexels.com/photos/1396132/pexels-photo-1396132.jpeg?auto=compress&cs=tinysrgb&w=1200",
            3, 9, 1, true, true, true, "South", 4,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security"),
            Arrays.asList("Shopping Mall - 1km", "Hospital - 1.5km", "School - 1.2km"));

        createProperty("Luxury 3BHK Apartment", "Vadodara", "Alkapuri",
            new BigDecimal(45000), 3, 3, 1650, "apartment", true,
            "Premium 3BHK in Alkapuri, Vadodara's upscale area.",
            "https://images.pexels.com/photos/1571453/pexels-photo-1571453.jpeg?auto=compress&cs=tinysrgb&w=1200",
            7, 14, 2, true, true, true, "West", 2,
            Arrays.asList("WiFi", "AC", "Swimming Pool", "Gym", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("Shopping Mall - 800m", "Hospital - 1.2km", "School - 1km"));

        createProperty("Modern 2BHK Flat", "Vadodara", "Gotri",
            new BigDecimal(30000), 2, 2, 1000, "apartment", true,
            "Contemporary 2BHK in Gotri with modern amenities.",
            "https://images.pexels.com/photos/1454805/pexels-photo-1454805.jpeg?auto=compress&cs=tinysrgb&w=1200",
            4, 11, 1, true, true, true, "East", 3,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security"),
            Arrays.asList("Shopping Mall - 1.2km", "Hospital - 1.8km", "School - 1.5km"));

        createProperty("Premium 2BHK Apartment", "Kochi", "Marine Drive",
            new BigDecimal(40000), 2, 2, 1200, "apartment", true,
            "Beautiful 2BHK near Marine Drive with sea view and modern amenities.",
            "https://images.pexels.com/photos/1571468/pexels-photo-1571468.jpeg?auto=compress&cs=tinysrgb&w=1200",
            5, 12, 1, true, true, true, "West", 2,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("Marine Drive - 300m", "Shopping Mall - 1km", "Hospital - 1.5km"));

        createProperty("Modern 3BHK Apartment", "Kochi", "Kakkanad",
            new BigDecimal(48000), 3, 3, 1550, "apartment", false,
            "Spacious 3BHK in Kakkanad, close to IT parks.",
            "https://images.pexels.com/photos/1396122/pexels-photo-1396122.jpeg?auto=compress&cs=tinysrgb&w=1200",
            6, 13, 2, true, true, true, "North", 3,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("IT Park - 1km", "Shopping Mall - 1.5km", "School - 1.2km"));

        createProperty("Luxury 4BHK Villa", "Bhopal", "Arera Colony",
            new BigDecimal(55000), 4, 4, 2300, "villa", true,
            "Premium villa in Arera Colony with private garden and modern amenities.",
            "https://images.pexels.com/photos/280222/pexels-photo-280222.jpeg?auto=compress&cs=tinysrgb&w=1200",
            1, 2, 3, false, true, true, "South", 1,
            Arrays.asList("WiFi", "AC", "Garden", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("Shopping Mall - 1.2km", "Hospital - 1.8km", "School - 1km"));

        createProperty("Modern 2BHK Flat", "Bhopal", "MP Nagar",
            new BigDecimal(28000), 2, 2, 980, "apartment", true,
            "Well-furnished 2BHK in MP Nagar with good connectivity.",
            "https://images.pexels.com/photos/1454806/pexels-photo-1454806.jpeg?auto=compress&cs=tinysrgb&w=1200",
            3, 9, 1, true, true, true, "East", 4,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security"),
            Arrays.asList("Shopping Mall - 800m", "Hospital - 1.5km", "School - 1km"));

        createProperty("Premium 3BHK Apartment", "Visakhapatnam", "MVP Colony",
            new BigDecimal(42000), 3, 3, 1600, "apartment", true,
            "Luxury 3BHK in MVP Colony with sea view and modern amenities.",
            "https://images.pexels.com/photos/1571460/pexels-photo-1571460.jpeg?auto=compress&cs=tinysrgb&w=1200",
            7, 15, 2, true, true, true, "East", 2,
            Arrays.asList("WiFi", "AC", "Swimming Pool", "Gym", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("Beach - 1km", "Shopping Mall - 1.2km", "Hospital - 1.5km"));

        createProperty("Modern 2BHK Flat", "Visakhapatnam", "Beach Road",
            new BigDecimal(35000), 2, 2, 1100, "apartment", true,
            "Beautiful 2BHK near Beach Road with stunning views.",
            "https://images.pexels.com/photos/1396132/pexels-photo-1396132.jpeg?auto=compress&cs=tinysrgb&w=1200",
            5, 12, 1, true, true, true, "East", 3,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("Beach - 200m", "Shopping Mall - 800m", "Hospital - 1.2km"));

        createProperty("Spacious 3BHK Apartment", "Patna", "Boring Road",
            new BigDecimal(32000), 3, 3, 1500, "apartment", false,
            "Well-maintained 3BHK in Boring Road, Patna.",
            "https://images.pexels.com/photos/1571453/pexels-photo-1571453.jpeg?auto=compress&cs=tinysrgb&w=1200",
            4, 10, 2, true, true, true, "North", 5,
            Arrays.asList("WiFi", "AC", "Parking", "24/7 Security", "Power Backup"),
            Arrays.asList("Shopping Mall - 1km", "Hospital - 1.5km", "School - 1.2km"));

        createProperty("Modern 2BHK Flat", "Patna", "Kankarbagh",
            new BigDecimal(25000), 2, 2, 950, "apartment", true,
            "Contemporary 2BHK in Kankarbagh with good amenities.",
            "https://images.pexels.com/photos/1454805/pexels-photo-1454805.jpeg?auto=compress&cs=tinysrgb&w=1200",
            3, 8, 1, true, true, true, "South", 4,
            Arrays.asList("WiFi", "AC", "Parking", "Security"),
            Arrays.asList("Shopping Mall - 1.2km", "Hospital - 1.8km", "School - 1km"));
    }

    private void createProperty(String title, String city, String area,
                               BigDecimal price, int bedrooms, int bathrooms, int areaSqft,
                               String propertyType, boolean furnished, String description,
                               String imageUrl, int floor, int totalFloors, int parking,
                               boolean liftAvailable, boolean powerBackup, boolean security,
                               String facing, int propertyAge, List<String> amenities, List<String> nearby) {
        Property property = new Property(title, city, area, price, bedrooms, bathrooms, areaSqft, propertyType);
        property.setFurnished(furnished);
        property.setDescription(description);
        property.setImageUrl(imageUrl);
        property.setFloor(floor);
        property.setTotalFloors(totalFloors);
        property.setParking(parking);
        property.setLiftAvailable(liftAvailable);
        property.setPowerBackup(powerBackup);
        property.setSecurity(security);
        property.setFacing(facing);
        property.setPropertyAge(propertyAge);
        property.setAmenities(String.join(",", amenities));
        property.setNearby(String.join(",", nearby));
        property.setAvailable(true);
        propertyRepository.save(property);
    }
}
