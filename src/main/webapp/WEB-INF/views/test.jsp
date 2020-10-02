<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
<%@    include file="header.jsp" %>
<head>
    <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
    <script type="text/javascript">

        window.onload = function () {
            let arr = [];
            let chart = new CanvasJS.Chart("chartContainer", {
                title: {
                    text: "Wykres pomiarów"
                },
                axisX: {
                    title: "Data pomiaru",
                    gridThickness: 2,
                    valueFormatString: "YYYY-MM-DD"
                },
                axisY: {
                    title: "Cukier"
                },
                data: [
                    {
                        type: "line",
                        xValueType: "dateTime",
                        dataPoints: arr[0]
                    }
                ]
            });

            let xValue;
            let yValue;
            <c:forEach items="${sugarDataChart}" var="sugars" varStatus="loop">

                    xValue = "${sugars.date}";
                    yValue = "${sugars.value}";
                    arr["${loop.index}"].push({
                        x: xValue,
                        y: yValue
                    });
            </c:forEach>
            chart.render();
        }
    </script>
</head>
<body>
<div id="chartContainer" style="height: 300px; width: 100%;"></div>
</body>
<%@    include file="footer.jsp" %>
</html>
