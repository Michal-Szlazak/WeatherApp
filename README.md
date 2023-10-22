# WeatherApp

WeatherApp is a simple weather application that allows you to search for location information and retrieve week-long weather forecasts with hourly details for each day. It uses the Geocode Maps API to search for locations and the Open Meteo API to fetch weather data.

## Features

- **Location Search**: You can search for a location by name using the Geocode Maps API. This feature allows you to find the weather forecast for your desired location.

- **Week-Long Weather Forecast**: WeatherApp provides a week-long weather forecast for the selected location, giving you an overview of the upcoming week's weather.

- **Hourly Weather Details**: For each day in the week-long forecast, you can view detailed weather information for every hour. This includes data like temperature, humidity, wind speed, and more.

## How to Use

1. **Installation**:
   Clone this repository to your local machine. Download all of the required dependencies:

   ```bash
   mvn clean install
   ```

2. **Run the Application**:
   Execute the application:

   ```bash
   mvn spring-boot run
   ```

3. **Open the web page**:
   Type the address in your browser:

   ```bash
   http://localhost:8080
   ```
     
5. **Use the app**:
   - After selecting a location, you can access the week-long weather forecast.
   - For each day, you can click on the day to reveal hourly weather details.

## Technologies Used

- Java, Spring, Thymeleaf
- Geocode Maps API
- Open Meteo API

---

Happy weather forecasting with WeatherApp! 🌦️
