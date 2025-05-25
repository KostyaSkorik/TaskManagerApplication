<%--
  Created by IntelliJ IDEA.
  User: kostya-skorik
  Date: 5/19/25
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- CSS Flickity -->
    <link rel="stylesheet" href="https://unpkg.com/flickity@2/dist/flickity.min.css">
    <!-- JS Flickity -->
    <script src="https://unpkg.com/flickity@2/dist/flickity.pkgd.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


    <title>Title</title>
    <style>
        body {
            min-height: 100vh;
            font-family: karla;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .viewport {
            width: 1000px;
            height: 600px;
            overflow: hidden;
            background-color: #fafafa;
            /*border: 1px solid #222;*/
        }

        .carousel-item {
            padding: 30px 10px;
            float: left;
        }

        .card {
            background-color: white;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.05);
            width: 500px;
            height: 500px;
        }

        .card__image {
            overflow: hidden;
            position: relative;
        }

        .card__image img {
            transform: scale(1.2);
        }

        .card__image .badge {
            position: absolute;
            left: 0;
            top: 0;
            right: 0;
            bottom: 0;
            margin: auto;
            background-color: white;
            padding: 10px;
            border-radius: 10px;
            width: 48px;
            height: 48px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 32px;
            color: #666;
            box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
        }

        .card__info {
            padding: 30px 30px 50px;
        }

        .card__title {
            font-weight: 400;
            margin-top: 0;
            line-height: 1;
        }

        .card__desc {
            opacity: 0.5;
        }
    </style>


</head>

<body>
<div class="viewport">
    <div class="carousel">
        <c:forEach items="${requestScope.tasks}" var="task">
            <form action="${pageContext.request.contextPath}/updateTask" method="post">
                <div class="carousel-item">
                    <div class="card">
                        <div class="card__image"><img src="http://unsplash.it/300/?image=58" alt=""/>
                            <div class="badge"><i class="fa fa-camera-retro"></i></div>
                        </div>
                        <div class="card__info">
                            <h2 class="card__title">
                                    ${task.getTitle()}</h2>
                            <div class="card__desc">
                                <p>Description: ${task.getDescription()}</p>
                                <p>Priority: ${task.getPriority()}</p>
                                <p>Deadline: ${task.getDeadline().getYear()} - ${task.getDeadline().getMonth()}
                                    - ${task.getDeadline().getDayOfMonth()}</p>
                            </div>
                        </div>
                    </div>
                    <input type="submit" value="Update" class="input-field">
                </div>
            </form>
        </c:forEach>
    </div>
</div>
</body>
</html>

<script type="text/javascript">
    var elem = document.querySelector('.carousel');
    var flkty = new Flickity(elem, {
        // options
        imagesLoaded: true,
        cellAlign: 'center',
        contain: true
    });

    var imgs = document.querySelectorAll(".card__image img");
    var docStyle = document.documentElement.style;
    var transformProp = typeof docStyle.transform == 'string' ? 'transform' : 'WebkitTransform';
    var info = document.querySelector(".info");

    flkty.on('scroll', function () {
        flkty.slides.forEach(function (slide, i) {
            var img = imgs[i];
            var x = (slide.target + flkty.x) * -1 / 3;

            img.style[transformProp] = 'translateX(' + x + 'px) scale(1.3)';
        });
    });
</script>
