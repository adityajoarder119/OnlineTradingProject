<%-- 
    Document   : chart
    Created on : Feb 1, 2022, 1:56:59 PM
    Author     : Laxman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
    </head>
    <body>
        <!--<div class="navbar"><span>Real-Time Chart with Plotly.js</span></div>-->
        <div class="wrapper">
            <div id="chart"></div>
            <canvas id="myChart"></canvas>
            <script>
                var xValues = ["Italy", "France", "Spain", "USA", "Argentina"];
                var yValues = [55, 49, 44, 24, 15];
                var barColors = ["red", "green", "blue", "orange", "brown"];

                new Chart("myChart", {
                    type: "bar",
                    data: {
                        labels: xValues,
                        datasets: [{
                                backgroundColor: barColors,
                                data: yValues
                            }]
                    },
                    options: {
                        legend: {display: false},
                        title: {
                            display: true,
                            text: "World Wine Production 2018"
                        }
                    }
                });
            </script>
        </div>
    </body>
</html>
