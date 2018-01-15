$("document").ready(function() {
console.log("CARGOOOOOOOO");
openCity(event, 'London');
});
function openCity(evt, cityName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active";
}
var chart = AmCharts.makeChart( "chartdiv", {
  "type": "pie",
  "theme": "light",
  "titles": [{
    "text": "Preferencias",
    "size": 13
}],
  "dataProvider": [ {
    "title": "Automóviles",
    "value": 2500
  }, {
    "title": "Restaurantes",
    "value": 3000
  } , {
    "title": "Turismo",
    "value": 1512
  } , {
    "title": "Fidelización y puntos",
    "value": 4350
  } ],
  "titleField": "title",
  "valueField": "value",
  "labelRadius": 5,

  "radius": "42%",
  "innerRadius": "60%",
  "labelText": "[[title]]",
  "export": {
    "enabled": true
  }
} );

var chart = AmCharts.makeChart("morachart", {
  "type": "serial",
  "theme": "light",
  "marginRight": 70,
  "titles": [{
    "text": "Vector de Hábito de Pago",
    "size": 13
}],
  "dataProvider": [
    {
      "country": "Enero",
      "visits": "400"
    },
    {
      "country": "Febrero",
      "visits": "250"
    },
    {
      "country": "Marzo",
      "visits": "-50"
    },
    {
      "country": "Abril",
      "visits": "-40"
    },
    {
      "country": "Junio",
      "visits": "-20"
    },
    {
      "country": "Julio",
      "visits": "45"
    },
    {
      "country": "Agosto",
      "visits": "102"
    }
  ],
  "valueAxes": [{
    "axisAlpha": 0,
    "position": "left",
    "title": "Pago de cuota(USD)"
  }],
  "startDuration": 1,
  "graphs": [{
    "balloonText": "<b>[[category]]: [[value]] USD</b>",
    "fillColorsField": "color",
    "fillAlphas": 0.9,
    "lineAlpha": 0.2,
    "type": "column",
    "valueField": "visits"
  }],
  "chartCursor": {
    "categoryBalloonEnabled": false,
    "cursorAlpha": 0,
    "zoomable": false
  },
  "categoryField": "country",
  "categoryAxis": {
    "gridPosition": "start",
    "labelRotation": 45
  },
  "export": {
    "enabled": true
  }

});
