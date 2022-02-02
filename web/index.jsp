<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <link href="https://unpks.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet">
        
        <title>Index page</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="assets/img/favicon.png" rel="icon">
        <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.gstatic.com" rel="preconnect">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.snow.css" rel="stylesheet">
        <link href="assets/vendor/quill/quill.bubble.css" rel="stylesheet">
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assets/vendor/simple-datatables/style.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">
        <style>
            #jaydeep{
                border-radius: 35px;
                
            }
            #statistics{
                border-radius: 45px;

            }
            #team{
                border-radius: 45px;
            }
            #logo{
                border-radius: 15px;
            }
            #logo-img{
                border-radius : 30px;
            }
            #secr{
                border-radius : 50px;
                opacity: 100%;
            }
            .main-wrap{
                border-radius : 50px;
            }
        </style>

    </head>

    <body bgcolor="lightblue">

        <!-- ======= Header ======= -->
        <header id="header" class="header fixed-top d-flex align-items-center">

            <div class="d-flex align-items-center justify-content-between">
                <a href="admin-dashboard.jsp" class="logo d-flex align-items-center">
                    <img src="assets/img/logo.png" alt="">
                    <span class="d-none d-lg-block">Exa-Trade</span>
                </a>
                <i class="bi bi-list toggle-sidebar-btn"></i>
            </div><!-- End Logo -->

            <div class="search-bar">
                <form class="search-form d-flex align-items-center" method="POST" action="#">
                    <input type="text" name="query" placeholder="Search" title="Enter search keyword">
                    <button type="submit" title="Search"><i class="bi bi-search"></i></button>
                </form>
            </div><!-- End Search Bar -->

            <nav class="header-nav ms-auto">
                <ul class="d-flex align-items-center">

                    <li class="nav-item d-block d-lg-none">
                        <a class="nav-link nav-icon search-bar-toggle " href="#">
                            <i class="bi bi-search"></i>
                        </a>
                    </li><!-- End Search Icon-->

                    <li class="nav-item dropdown pe-3">

                        <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">

                            <span class="d-none d-md-block dropdown-toggle ps-2"><s:property value="#session.name" /></span>
                        </a><!-- End Profile Iamge Icon -->

                        <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                            <li class="dropdown-header">
                                <h6><s:property value="#session.name" /></h6>
                                <span>Web Designer</span>
                            </li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>



                            <li>
                                <a class="dropdown-item d-flex align-items-center" href="pages-faq.jsp">
                                    <i class="bi bi-question-circle"></i>
                                    <span>Need Help?</span>
                                </a>
                            </li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>

                            <li>
                                <a class="dropdown-item d-flex align-items-center" href="logout">
                                    <i class="bi bi-box-arrow-right"></i>
                                    <span>Sign Out</span>
                                </a>
                            </li>

                        </ul><!-- End Profile Dropdown Items -->
                    </li><!-- End Profile Nav -->

                </ul>
            </nav><!-- End Icons Navigation -->

        </header><!-- End Header -->

        <!-- ======= Sidebar ======= -->
        <aside id="sidebar" class="sidebar">

            <ul class="sidebar-nav" id="sidebar-nav">

                <li class="nav-item">
                    <a class="nav-link " href="reportstockindex">
                        <i class="bi bi-grid"></i>
                        <span>Dashboard</span>
                    </a>
                </li><!-- End Dashboard Nav -->

                <li class="nav-heading">Pages</li>

                <li class="nav-item">
                    <a class="nav-link collapsed" href="pages-register.jsp">
                        <i class="bi bi-card-list"></i>
                        <span>Register</span>
                    </a>
                </li><!-- End Register Page Nav -->

                <li class="nav-item">
                    <a class="nav-link collapsed" href="pages-login.jsp">
                        <i class="bi bi-box-arrow-in-right"></i>
                        <span>Login</span>
                    </a>
                </li><!-- End Login Page Nav -->

                <li class="nav-item">
                    <a class="nav-link collapsed" href="pages-faq.jsp">
                        <i class="bi bi-question-circle"></i>
                        <span>F.A.Q</span>
                    </a>
                </li><!-- End F.A.Q Page Nav -->

                <li class="nav-item">
                    <a class="nav-link collapsed" href="pages-contact.jsp">
                        <i class="bi bi-envelope"></i>
                        <span>Contact</span>
                    </a>
                </li><!-- End Contact Page Nav -->

            </ul>

        </aside><!-- End Sidebar-->

        <main id="main" class="main" >

<!--            <a href="admin-dashboard.jsp" class="logo d-flex align-items-center" >
                    <img src="assets/img/logo.png" alt="image logo"   >
                    <span class="d-none d-lg-block"   >Exa-Trade</span>
                </a>-->
<!--            
        </main><!-- End #main -->
<!--Content-->
<section id="logo" class="text-gray-600 body-font" style="background-color:#E5E7E9">
  <div class="container mx-auto flex px-5 py-24 md:flex-row flex-col ">
    <div class="lg:flex-grow md:w-1/2 lg:pr-24 md:pr-16 flex flex-col md:items-start md:text-left mb-16 md:mb-0 items-center text-center">
      <h1 class="title-font sm:text-4xl text-3xl mb-4 font-medium text-gray-900" style="font-family: fantasy">The New Face of Financial Research
        
      </h1>
      <p class="mb-8 leading-relaxed">An intuitively designed workspace for delivering powerful market insight</p>
      <div class="flex justify-center">
        <!--<button class="inline-flex text-white bg-indigo-500 border-0 py-2 px-6 focus:outline-none hover:bg-indigo-600 rounded text-lg">Button</button>-->
        <!--<button class="ml-4 inline-flex text-gray-700 bg-gray-100 border-0 py-2 px-6 focus:outline-none hover:bg-gray-200 rounded text-lg">Button</button>-->
      </div>
    </div>
    <div class="lg:max-w-lg lg:w-full md:w-1/2 w-5/6">
      <img id="logo-img" class="object-cover object-center rounded responsive" alt="logo" src="assets/img/Exa-Trade.png" width="1100" height="500" >
    </div>
  </div>
    <p></P>
        <p></P>
    <p></P>
    <p></P>
    <p></P>
    <p></P>

</section>

<!-- Security-->
<section id="secr" class="text-gray-600 body-font overflow-hidden">
  <div class="container px-5 py-24 mx-auto" alt="No img" style="background-color: #EFF0F2;" >
    <div class="-my-8 divide-y-2 divide-gray-100">
      <div class="py-8 flex flex-wrap md:flex-nowrap">
        <div class="md:w-64 md:mb-0 mb-6 flex-shrink-0 flex flex-col">
          
        </div>
        <div class="md:flex-grow">
          <h2 class="text-2xl font-medium text-gray-900 title-font mb-2" style=" font-family: fantasy; color: #292B2C">Security Snapshot View</h2>
          <p class="leading-relaxed">News, fundamentals, and charts accessible through a comprehensive security snapshot. Gain clarity by seeing the entire picture without missing a detail. Includes balance sheets and income statements, SEC filings, press releases, and key corporate information</p>
          
        </div>
      </div>
     
    </div>
  </div>
</section>

<!--newdesk Access-->
<section id="secr" class="text-gray-600 body-font overflow-hidden">
  <div class="container px-5 py-24 mx-auto" alt="No img" style="background-color: #EFF0F2;" >
    <div class="-my-8 divide-y-2 divide-gray-100">
      <div class="py-8 flex flex-wrap md:flex-nowrap">
        <div class="md:w-64 md:mb-0 mb-6 flex-shrink-0 flex flex-col">
          
        </div>
        <div class="md:flex-grow">
          <h2 class="text-2xl font-medium text-gray-900 title-font mb-2" style=" font-family: fantasy; color: #292B2C">Exclusive Newsdesk Access</h2>
          <p class="leading-relaxed">Giving traders the opportunity to gain context and seek answers straight from the source. Available every trading day, users can instantly open a conversation with a reporter at Eax-Trade’s headquarters.</p>
          
        </div>
      </div>
     
    </div>
  </div>
    
    <p></p>
        <p></p>
    <p></p>

</section>


<!--Statistic of ExaTrade-->
<section id="statistics" class="text-gray-600 body-font" style="background-color:#E5E7E9">
  <div class="container px-5 py-24 mx-auto flex flex-wrap">
    <div class="flex flex-wrap -mx-4 mt-auto mb-auto lg:w-1/2 sm:w-2/3 content-start sm:pr-10">
      <div class="w-full sm:p-4 px-4 mb-6">
          <h1 class="title-font font-medium text-xl mb-2 text-gray-900" style="font-family: Fantasy; color:black " ><a href="pages-register.jsp" style="color:#292B2C"><u>Open Free Tarding Account</u></a></h1>
        <div class="leading-relaxed" style="font-family: cursive; color: black" s>Investments at your Fingertips with EXA-TRADE</div>
      </div>
        
      <div class="p-4 sm:w-1/2 lg:w-1/4 w-1/2">
        <h2 class="title-font font-medium text-3xl text-gray-900">2.7K</h2>
        <p class="leading-relaxed">Users</p> 
      </div>
      <div class="p-4 sm:w-1/2 lg:w-1/4 w-1/2">
        <h2 class="title-font font-medium text-3xl text-gray-900">1.8K</h2>
        <p class="leading-relaxed">Subscribes</p>
      </div>
      <div class="p-4 sm:w-1/2 lg:w-1/4 w-1/2">
        <h2 class="title-font font-medium text-3xl text-gray-900">4000+</h2>
        <p class="leading-relaxed">Products</p>
      </div>
    </div>
  </div>
    <p></p>
    <p></p>
    <p></p>
    <p></p>
</section>




<!--Our Team-->
<section id="team" class="text-gray-600 body-font" style="background-color:#E5E7E9">
  <div class="container px-5 py-24 mx-auto">
    <div class="flex flex-col text-center w-full mb-20">
      <h1 class="sm:text-3xl text-2xl font-medium title-font mb-4 text-gray-900" style="font-family:Blippo, fantasy ; color:black; font-size:50px " >Our Team</h1>
      <p class="lg:w-2/3 mx-auto leading-relaxed text-base" style="font-family: cursive;">The way a team plays as a whole determines its success. You may have the greatest 
          bunch of individual stars in the world, but if they don’t play together, the club won’t be worth a dime.</p>
    </div>
    
    <div class="flex flex-wrap -m-2">
        
      <div class="p-2 lg:w-1/3 md:w-1/2 w-full">
        <div class="h-full flex items-center border-gray-200 border p-4 rounded-lg">
          <img id="jaydeep" src="img/Jaydeep.jpg"  alt="pic of Jay" width="180" height="160" />
          <div class="flex-grow">
              <h2 class="text-gray-900 title-font font-medium"  style="font-family: Impact, fantasy"><a href="https://www.linkedin.com/in/jaydeep-das-773756194/">Jaydeep Das</a></h2>
            <p class="text-gray-500" >Digital Intern,</p> 
          </div>
        </div>
      </div>
      <div class="p-2 lg:w-1/3 md:w-1/2 w-full">
        <div class="h-full flex items-center border-gray-200 border p-4 rounded-lg">
          <img id="jaydeep" src="img/abhineet (2).jpg" alt="pic of abhineet" width="180" height="160" />
            <div class="flex-grow">
                <h2 class="text-gray-900 title-font font-medium" style="font-family: Impact, fantasy"><a href="https://www.linkedin.com/in/abhineet64">Abhineet Mishra</a></h2>
            <p class="text-gray-500">Digital Intern</p>
          </div>
        </div>
      </div>
      <div class="p-2 lg:w-1/3 md:w-1/2 w-full">
        <div class="h-full flex items-center border-gray-200 border p-4 rounded-lg">
            <img id="jaydeep" src="img/aditya.jpg" alt="pic of aditya" width="180" height="170" />
            <div class="flex-grow">
                <h2 class="text-gray-900 title-font font-medium" style="font-family: Impact, fantasy"><a href="https://www.linkedin.com/in/aditya-joarder-76658aa9">Aditya Joarder</a></h2>
            <p class="text-gray-500">Digital Intern</p>
          </div>
        </div>
      </div>
      <div class="p-2 lg:w-1/3 md:w-1/2 w-full">
        <div class="h-full flex items-center border-gray-200 border p-4 rounded-lg">
            <img id="jaydeep" src="img/ritu.png" alt="pic of ritu" width="180" height="160" />
            <div class="flex-grow">
                <h2 class="text-gray-900 title-font font-medium" style="font-family: Impact, fantasy"><a href="https://www.linkedin.com/in/rituparna-bhattacharya-144545190/">Rituparna Bhattacharya</a></h2>
            <p class="text-gray-500">Digital Intern</p>
          </div>
        </div>
      </div>
      <div class="p-2 lg:w-1/3 md:w-1/2 w-full">
        <div class="h-full flex items-center border-gray-200 border p-4 rounded-lg">
          <img id="jaydeep" src="img/rajshekhar.jpg" alt="pic of abhineet" width="180" height="160" />
          <div class="flex-grow">
              <h2 class="text-gray-900 title-font font-medium" style="font-family: Impact, fantasy"><a href="https://www.linkedin.com/in/rajasekhar-gullapalli-7273a1207">Gullapalli Rajshekhar</a></h2>
            <p class="text-gray-500">Digital Intern</p>
          </div>
        </div>
      </div>
      <div class="p-2 lg:w-1/3 md:w-1/2 w-full">
        <div class="h-full flex items-center border-gray-200 border p-4 rounded-lg">
          <img id="jaydeep" src="img/suraj.jpg" alt="pic of abhineet" width="180" height="160" />
          <div class="flex-grow">
              <h2 class="text-gray-900 title-font font-medium" style="font-family: Impact, fantasy"><a href="https://www.linkedin.com/in/suraj-kumar-7076a4194">Suraj Kumar</a></h2>
            <p class="text-gray-500">Digital Intern</p>
          </div>
        </div>
      </div>
     
    </div>
  </div>
</section>


        <!-- ======= Footer ======= -->
        <footer id="footer" class="footer">
            <div class="copyright">
                &copy; Copyright <strong><span>NiceAdmin</span></strong>. All Rights Reserved
            </div>
            <div class="credits">
                <!-- All the links in the footer should remain intact. -->
                <!-- You can delete the links only if you purchased the pro version. -->
                <!-- Licensing information: https://bootstrapmade.com/license/ -->
                <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/ -->
                Designed by <a href="https://bootstrapmade.com/">Exavalu Group A</a>
            </div>
        </footer><!-- End Footer -->

        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

        <script>
            $(document).ready(function () {
                function disableBack() {
                    window.history.forward()
                }
                window.onload = disableBack();
                window.onpageshow = function (e) {
                    if (e.persisted)
                        disableBack();
                }
            });
        </script>

        <script src=
                "https://code.jquery.com/jquery-3.6.0.min.js" 
                integrity=
                "sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
        crossorigin="anonymous"></script>
        <!-- Vendor JS Files -->
        <script src="assets/vendor/apexcharts/apexcharts.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/chart.js/chart.min.js"></script>
        <script src="assets/vendor/echarts/echarts.min.js"></script>
        <script src="assets/vendor/quill/quill.min.js"></script>
        <script src="assets/vendor/simple-datatables/simple-datatables.js"></script>
        <script src="assets/vendor/tinymce/tinymce.min.js"></script>
        <script src="assets/vendor/php-email-form/validate.js"></script>

        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>

    </body>

</html>