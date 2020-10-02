<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
<%@	include file="header.jsp"%>
<head>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">--%>
    <div>
        <canvas id="sugarsChart" width="600" height="400">
    <script type="text/javascript">
        window.onload = function () {
            var chart = new CanvasJS.Chart("chartContainer",
                {
                    title:{
                        text: "Simple Date-Time Chart"
                    },
                    axisX:{
                        title: "timeline",
                        gridThickness: 2
                    },
                    axisY: {
                        title: "Downloads"
                    },
                    data: [
                        {
                            type: "area",
                            dataPoints: [//array
                                { x: new Date(2012, 0o1, 1), y: 26},
                                { x: new Date(2012, 0o1, 3), y: 38},
                                { x: new Date(2012, 0o1, 5), y: 43},
                                { x: new Date(2012, 0o1, 7), y: 29},
                                { x: new Date(2012, 0o1, 11), y: 41},
                                { x: new Date(2012, 0o1, 13), y: 54},
                                { x: new Date(2012, 0o1, 20), y: 66},
                                { x: new Date(2012, 0o1, 21), y: 60}
                            ]
                        }
                    ]
                });

            chart.render();
        }
    </script>
        </canvas>
    </div>
</head>
<body>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
<%@	include file="footer.jsp"%>
</html>
