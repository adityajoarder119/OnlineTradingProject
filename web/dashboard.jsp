<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <div>
    <table>
        <tr>
            <th><a href="reportstock"><button  type="button" style="cursor: pointer;">Stock Report</button></a></th>
        </tr>
    </table>
</div>
        <h2>Stock Report</h2>
        <div style="margin-top: 40px;">
            <s:if test="noData==false">
                <table>
                    <thead>
                        <tr style="background-color: #E0E0E1;">
                            <th>Stock ID</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Availability</th>
                           
                        </tr>
                    </thead>
                    <s:iterator value="stockList">
                        <tr>
                            <td><s:property value="stockId" /></td>
                            <td><s:property value="stockName" /></td>
                            <td><s:property value="price" /></td>
                            <td><s:property value="availability" /></td> 
                        </tr>
                    </s:iterator>
                </table>
            </s:if>
            <s:else>
                <div style="color: red;">No Data Found.</div>
            </s:else>
        </div>
    </body>
</html>
