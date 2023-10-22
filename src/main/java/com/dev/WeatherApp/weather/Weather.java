package com.dev.WeatherApp.weather;

import com.dev.WeatherApp.ObjectToJsonMapper;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Getter
@Component
@SessionScope
public class Weather {

    private Map<String, Day> days;
    private List<Map.Entry<String, Day>> entrySet;

    public void loadDailyWeatherData(DailyWeatherData dailyWeatherData) {

        days = new TreeMap<>();

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("HH:mm", Locale.ENGLISH);

        int numberOfDays = dailyWeatherData.getDates().size();

        List<String> dates = dailyWeatherData.getDates();
        List<Long> maxTemperature = dailyWeatherData.getMaxTemperature();
        List<Long> minTemperature = dailyWeatherData.getMinTemperature();
        List<Long> apparentMaxTemperature = dailyWeatherData.getApparentMaxTemperature();
        List<Long> apparentMinTemperature = dailyWeatherData.getApparentMinTemperature();
        List<Long> precipitationSum = dailyWeatherData.getPrecipitationSum();
        List<Long> rainSum = dailyWeatherData.getRainSum();
        List<Long> showersSum = dailyWeatherData.getShowersSum();
        List<Long> snowfallSum = dailyWeatherData.getSnowfallSum();
        List<Long> precipitationProbabilityMean = dailyWeatherData.getPrecipitationProbabilityMean();
        List<String> sunrise = dailyWeatherData.getSunrise();
        List<String> sunset = dailyWeatherData.getSunset();
        List<Long> windSpeedMax = dailyWeatherData.getWindSpeedMax();


        for(int i = 0; i < numberOfDays; i++) {

            String inputSunrise = sunrise.get(i);
            LocalDateTime dateTime = LocalDateTime.parse(inputSunrise, inputFormatter);
            String formattedSunrise = dateTime.format(outputFormatter);
            String inputSunset = sunset.get(i);
            dateTime = LocalDateTime.parse(inputSunset, inputFormatter);
            String formattedSunset = dateTime.format(outputFormatter);

            Day day = Day.builder()
                    .date(dates.get(i))
                    .maxTemperature(maxTemperature.get(i))
                    .minTemperature(minTemperature.get(i))
                    .apparentMaxTemperature(apparentMaxTemperature.get(i))
                    .apparentMinTemperature(apparentMinTemperature.get(i))
                    .precipitationSum(precipitationSum.get(i))
                    .rainSum(rainSum.get(i))
                    .showersSum(showersSum.get(i))
                    .snowfallSum(snowfallSum.get(i))
                    .precipitationProbabilityMean(precipitationProbabilityMean.get(i))
                    .sunrise(formattedSunrise)
                    .sunset(formattedSunset)
                    .windSpeedMax(windSpeedMax.get(i))
                    .build();

            days.put(dates.get(i), day);
        }

        entrySet = new ArrayList<>(days.entrySet());
    }

    public Day getDay(String date) {
        return days.get(date);
    }

    public String toString() {
        System.out.println(this.days.values());
        return ObjectToJsonMapper.map(this);
    }

}
