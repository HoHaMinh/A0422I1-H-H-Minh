<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail</title>
    <style>
        table, tr, th, td {
            border: solid 1px;
        }
        tr, th, td {
            width: 300px;
            height: 50px;
        }
        .color
        {
        color: blue;
        }
    </style>
</head>
<body>
<c:if test="${empty detail.name}">
    <h1 style="color: red">Bạn chưa có tờ khai nào</h1>
</c:if>
<c:if test="${not empty detail.name}">
    <h1 style="color: blue">Your last medical declaration</h1>
    <table>
        <tr>
            <td class="color">
                Họ tên (*):
            </td>
            <td>
                    ${detail.name}
            </td>
        </tr>
        <tr>
            <td class="color">
                Năm sinh (*):
            </td>
            <td>
                    ${detail.yearOfBirth}
            </td>
        </tr>
        <tr>
            <td class="color">
                Giới tính (*):
            </td>
            <c:if test="${detail.gender == true}">
                <td>
                    Nam
                </td>
            </c:if>
            <c:if test="${detail.gender == false}">
                <td>
                    Nữ
                </td>
            </c:if>
        </tr>
        <tr>
            <td class="color">
                Quốc tịch (*):
            </td>
            <td>
                    ${detail.nationality}
            </td>
        </tr>
        <tr>
            <td class="color">
                Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác (*):
            </td>
            <td>
                    ${detail.nationalityId}
            </td>
        </tr>
        <tr>
            <td class="color">
                Phương tiện đi lại (*):
            </td>
            <td>
                    ${detail.transportVehicle}
            </td>
        </tr>
        <tr>
            <td class="color">
                Số hiệu phương tiện:
            </td>
            <td>
                    ${detail.vehicleId}
            </td>
        </tr>
        <tr>
            <td class="color">
                Số ghế:
            </td>
            <td>
                    ${detail.seatNo}
            </td>
        </tr>
        <tr>
            <td class="color">
                Ngày khởi hành (*):
            </td>
            <td>
                    ${detail.startDate.getDate()}/${detail.startDate.getMonth()+1}/${detail.startDate.getYear()+1900}
            </td>
        </tr>
        <tr>
            <td class="color">
                Ngày kết thúc (*):
            </td>
            <td>
                    ${detail.endDate.getDate()}/${detail.endDate.getMonth()+1}/${detail.endDate.getYear()+1900}
            </td>
        </tr>
        <tr>
            <td class="color">
                Trong 14 ngày qua, Anh/Chị đã đến thành phố (*):
            </td>
            <td>
                    ${detail.visitedCity}
            </td>
        </tr>
        <tr>
            <td class="color">
                Địa chỉ liên lạc (*):
            </td>
            <td>
                    ${detail.livingOfAddress} ${detail.wardOfAddress} ${detail.districtOfAddress} ${detail.cityOfAddress}
            </td>
        </tr>
        <tr>
            <td class="color">
                Điện thoại (*):
            </td>
            <td>
                    ${detail.phone}
            </td>
        </tr>
        <tr>
            <td class="color">
                Email (*):
            </td>
            <td>
                    ${detail.email}
            </td>
        </tr>
        <tr>
            <td class="color">
                Trong 14 ngày qua, Anh/Chị có các triệu chứng (*):
            </td>
            <c:if test="${empty detail.symptom}">
                <td>
                    Không có triệu chứng nào
                </td>
            </c:if>
            <c:if test="${not empty detail.symptom}">
                <td>
                        ${detail.symptom}
                </td>
            </c:if>
        </tr>
        <tr>
            <td class="color">
                Trong 14 ngày qua, Anh/Chị có các lịch sử phơi nhiễm (*):
            </td>
            <td>
                <c:if test="${detail.visitDangerousPlaces==true}">
                    Có đến trang trại chăn nuôi/ chợ buôn bán động vật sống, cơ sở giết mổ động vật/ tiếp xúc động vật
                    <br>
                </c:if>
                <c:if test="${detail.contactIllPerson==true}">
                    Có tiếp xúc gần (<2m) với người mắc bệnh viêm đường hô hấp do nCOV
                </c:if>
                <c:if test="(${(detail.contactIllPerson==false) and (detail.visitDangerousPlaces=false)}">
                    Không có lịch sử phơi nhiễm
                </c:if>
            </td>
        </tr>
    </table>
</c:if>
<a href="/">
    <button type="submit">Trở về menu chính</button>
</a>
</body>
</html>
