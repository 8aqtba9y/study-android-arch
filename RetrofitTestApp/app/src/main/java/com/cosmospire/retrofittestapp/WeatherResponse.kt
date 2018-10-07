package com.cosmospire.retrofittestapp

class WeatherResponse {
    internal var pinPointLocations: List<PinPointLocation>? = null
    internal var link: String? = null
    internal var forecasts: List<Forecast>? = null
    internal var location: Location? = null
    internal var publicTime: String? = null
    internal var copyright: Copyright? = null
    internal var title: String? = null
    internal var description: Description? = null

    internal class PinPointLocation {
        var link: String? = null
        var name: String? = null
    }

    internal class Forecast {
        var dateLavel: String? = null
        var telop: String? = null
        var temperature: Temperature? = null
        var image: Image? = null
    }

    internal class Temperature {
        var min: TemperatureSub? = null
        var max: TemperatureSub? = null

        internal class TemperatureSub {
            var celsius: String? = null
            var fahrenheit: String? = null
        }
    }

    internal class Image {
        var width: Int = 0
        var url: String? = null
        var title: String? = null
        var height: Int = 0
    }

    internal class Location {
        var city: String? = null
        var area: String? = null
        var prefecture: String? = null
    }

    internal class Copyright {
        var provider: List<Provider>? = null
        var link: String? = null
        var title: String? = null
        var image: Image? = null

        internal class Provider {
            var link: String? = null
            var name: String? = null
        }
    }

    internal class Description {
        var text: String? = null
        var publicTime: String? = null
    }
}
