/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wladmir.conversor.util;

/**
 *
 * @author Wladmir Rodrigues
 */
public class ConversaoTemperatura {
    
    public String converter(int method, double valor){
        String result;
        result = switch (method) {
            case 0 -> celsiusParaFahrenheit(valor);
            case 1 -> celsiusParaKelvin(valor);
            case 2 -> fahrenheitParaCelsius(valor);
            case 3 -> fahrenheitParaKelvin(valor);
            case 4 -> kelvinParaCelsius(valor);
            case 5 -> kelvinParaFahrenheit(valor);
            default -> "";
        };
         return result;
        
    }
    // De Celsius para Fahrenheit
    private String celsiusParaFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32 + "°F";
    }

    // De Celsius para Kelvin
    private String celsiusParaKelvin(double celsius) {
       return celsius + 273.15 + "K";
    }

    // De Fahrenheit para Celsius
    private String fahrenheitParaCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9 + "°C";
    }

    // De Fahrenheit para Kelvin
   private String fahrenheitParaKelvin(double fahrenheit) {
        return (fahrenheit + 459.67) * 5 / 9 + "K";
    }

    // De Kelvin para Celsius
    private String kelvinParaCelsius(double kelvin) {
        return kelvin - 273.15 + "°C";
    }

    // De Kelvin para Fahrenheit
     private String kelvinParaFahrenheit(double kelvin) {
        return kelvin * 9 / 5 - 459.67 + "°F";
    }
    
}
