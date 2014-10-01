<!DOCTYPE html>
<html>
<head>
    <title>Cloud Foundry Scale Demo</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen"/>
</head>
<body>
<div class="container">
    <div class="hero-unit">
        <h1>Cloud Foundry Scale Demo</h1>

        <p>Powered by <a href="http://projects.spring.io/spring-boot">Spring Boot</a> and <a href="http://groovy.codehaus.org">Groovy</a>!</p>
    </div>

    <h2>App Instance Info: </h2>

    <table class="table table-striped table-hover">
    	<tr><td><strong>App Name</strong></td><td>${applicationName}</td></tr>
    	<tr class="info"><td><strong>Instance</strong></td><td>${instance}</td></tr>
    	<tr><td><strong>Memory Allocated</strong></td><td>${mem}</td></tr>
    	<tr><td><strong>Disk Allocated</strong></td><td>${disk}</td></tr>
    	<tr><td><strong>Instance IP</strong></td><td>${ipAddress}</td></tr>
    	<tr><td><strong>Instance Port</strong></td><td>${port}</td></tr>
    	<tr class="info"><td><strong>Requests Serviced</strong></td><td>${requestsServed}</td></tr>
    </table>

    <p style="text-align: center"><img src="img/LOGO_CloudFoundry_Large.png"/></p>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>


