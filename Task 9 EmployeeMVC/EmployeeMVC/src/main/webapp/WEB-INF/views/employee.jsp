<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Employee Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
            background-color: #f4f4f4;
        }
        .card {
            background: white;
            border-radius: 8px;
            padding: 30px;
            max-width: 400px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
        }
        h2 {
            color: #333;
            border-bottom: 2px solid #4CAF50;
            padding-bottom: 10px;
        }
        p {
            font-size: 16px;
            color: #555;
            margin: 10px 0;
        }
        span {
            font-weight: bold;
            color: #222;
        }
    </style>
</head>
<body>
    <div class="card">
        <h2>Employee Information</h2>
        <p>ID:         <span>${employee.id}</span></p>
        <p>Name:       <span>${employee.name}</span></p>
        <p>Department: <span>${employee.department}</span></p>
    </div>
</body>
</html>
