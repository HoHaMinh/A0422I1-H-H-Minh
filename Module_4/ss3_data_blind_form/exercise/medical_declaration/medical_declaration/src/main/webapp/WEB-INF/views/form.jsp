<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
    <style>
        .full {
            width: 100%;
        }

        .seperate {
            width: 33.33%;
            float: left;
        }

        .half {
            width: 50%;
            float: left;
        }

        .red {
            color: red;
        }

        span {
            font-weight: bold;
        }
    </style>
</head>
<body>
<h4 style="text-align: center; align-content: center; width: 100%">
    Tờ khai y tế <br>
    Đây là tài liệu quan trọng, thông tin của Anh/Chị sẽ giúp cơ quan y tế liên lạc khi cần thiết để phòng chống dịch
    bệnh truyền nhiễm
    <br>
    <h5 style="color: red;text-align: center; align-content: center; width: 100%">
        Khuyến cáo khai báo thông tin sai là vi pham pháp luật Việt Nam và có thể bị xử lý hình sự
    </h5>
</h4>
<form:form action="/addOrUpdate" method="post" modelAttribute="medicalDeclaration">
    <div class="full">
        <span>Họ tên ghi chữ IN HOA</span>
        <span class="red"> (*)</span> <br>
        <form:input path="name" cssClass="full" required="required"/>
    </div>
    <br>
    <div class="full">
        <div class="seperate">
            <span>Năm sinh</span>
            <span class="red"> (*)</span>
        </div>
        <div class="seperate">
            <span>Giới tính</span>
            <span class="red"> (*)</span>
        </div>
        <div class="seperate">
            <span>Quốc tịch</span>
            <span class="red"> (*)</span>
        </div>
        <br>
        <div class="seperate">
            <form:select path="yearOfBirth" cssClass="full">
                <form:options items="${yearOfBirth}"/>
            </form:select>
        </div>
        <div class="seperate">
            <form:select path="gender" cssClass="full">
                <form:option value="true">Nam</form:option>
                <form:option value="false">Nữ</form:option>
            </form:select>
        </div>
        <div class="seperate">
            <form:select path="nationality" cssClass="full">
                <form:options items="${nationality}"/>
            </form:select>
        </div>
    </div>
    <br>
    <br>
    <div class="full">
        <span>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</span>
        <span class="red"> (*)</span> <br>
        <form:input path="nationalityId" cssClass="full" required="required"/>
    </div>
    <br>
    <div class="full">
        <span>Thông tin đi lại</span>
        <span class="red"> (*)</span> <br>
        <form:radiobuttons path="transportVehicle" items="${transportVehicle}" required="required"/>
    </div>
    <br>
    <div class="full">
        <div class="half">
            <p>Số hiệu phương tiện</p>
            <form:input path="vehicleId" cssClass="full"/>
        </div>
        <div class="half">
            <p>Số ghế</p>
            <form:input path="seatNo" cssClass="full"/>
        </div>
    </div>
    <br>
    <br>
    <div class="full">
        <div class="half">
            <span>Ngày khởi hành</span>
            <span class="red"> (*)</span> <br>
            <form:input type="date" path="startDate" cssClass="full" required="required"/>
        </div>
        <div class="half">
            <span>Ngày kết thúc</span>
            <span class="red"> (*)</span><br>
            <form:input type="date" path="endDate" cssClass="full" required="required"/>
        </div>
    </div>
    <br>
    <br>
    <div class="full">
        <span>Trong vòng 14 ngày qua Anh/Chị có đến tỉnh/thành nào</span>
        <span class="red"> (*)</span> <br>
        <form:input path="visitedCity" cssClass="full" required="required"/>
    </div>
    <br>
    <div class="full">
        <span>Địa chỉ liên lạc: </span><br>
        <div class="seperate">
            <span>Tỉnh/thành</span>
            <span class="red"> (*)</span> <br>
            <form:select path="cityOfAddress" cssClass="full">
                <form:options items="${cityOfAddress}"/>
            </form:select>
        </div>
        <div class="seperate">
            <span>Quận/huyện</span>
            <span class="red"> (*)</span> <br>
            <form:select path="districtOfAddress" cssClass="full">
                <form:options items="${districtOfAddress}"/>
            </form:select>
        </div>
        <div class="seperate">
            <span>Phường/xã</span>
            <span class="red"> (*)</span> <br>
            <form:select path="wardOfAddress" cssClass="full">
                <form:options items="${wardOfAddress}"/>
            </form:select>
        </div>
    </div>
    <div class="full">
        <span>Địa chỉ nơi ở </span>
        <span class="red"> (*)</span> <br>
        <form:input path="livingOfAddress" cssClass="full" required="required"/>
    </div>
    <div class="full">
        <div class="half">
            <span>Điện thoại</span>
            <span class="red"> (*)</span>
            <form:input path="phone" cssClass="full" required="required"/>
        </div>
        <div class="half">
            <span>Email</span>
            <span class="red"> (*)</span>
            <form:input path="email" cssClass="full" required="required"/>
        </div>
    </div>
    <br>
    <br>
    <div class="full">
        <span>
            Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiệu dấu hiệu nào sau đây không?
        </span>
        <span class="red">
             (*)
        </span>
        <br>
        <form:checkboxes path="symptom" items="${symptom}"/>
    </div>
    <br>
    <br>
    <div class="full">
        <span>
            Lịch sử phơi nhiễm: Trong 14 ngày qua, Anh/Chị có
        </span>
        <span class="red">
             (*)
        </span>
        <br>
        <div class="full">
            <span>
                Đến trang trại chăn nuôi/ chợ buôn bán động vật sống, cơ sở giết mổ động vật/ tiếp xúc động vật
            </span>
            <form:checkbox path="visitDangerousPlaces" value="true"/>
        </div>
        <div>
            <span>
                Tiếp xúc gần (<2m) với người mắc bệnh viêm đường hô hấp do nCOV
            </span>
            <form:checkbox path="contactIllPerson" value="true"/>
        </div>
    </div>
    <button type="submit">Gởi tờ khai</button>
</form:form>
<a href="/">
    <button type="submit">Trở lại menu chính</button>
</a>
</body>
</html>
