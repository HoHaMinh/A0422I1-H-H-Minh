<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail</title>
</head>
<body>
<table>
    <tr>
        <td>
            Họ tên (*):
        </td>
        <td>
            ${detail.name}
        </td>
    </tr>
    <tr>
        <td>
            Năm sinh (*):
        </td>
        <td>
            ${detail.yearOfBirth}
        </td>
    </tr>
    <tr>
        <td>
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
        <td>
            Quốc tịch (*):
        </td>
        <td>
            ${detail.nationality}
        </td>
    </tr>
    <tr>
        <td>
            Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác (*):
        </td>
        <td>
            ${detail.nationalityId}
        </td>
    </tr>
    <tr>
        <td>
            Phương tiện đi lại (*):
        </td>
        <td>
            ${detail.transportVehicle}
        </td>
    </tr>
    <tr>
        <td>
            Số hiệu phương tiện:
        </td>
        <td>
            ${detail.vehicleId}
        </td>
    </tr>
    <tr>
        <td>
            Số ghế:
        </td>
        <td>
            ${detail.seatNo}
        </td>
    </tr>
    <tr>
        <td>
            Ngày khởi hành (*):
        </td>
        <td>
            ${detail.startDate}
        </td>
    </tr>
    <tr>
        <td>
            Ngày kết thúc (*):
        </td>
        <td>
            ${detail.endDate}
        </td>
    </tr>
    <tr>
        <td>
            Trong 14 ngày qua, Anh/Chị đã đến thành phố (*):
        </td>
        <td>
            ${detail.visitedCity}
        </td>
    </tr>
    <tr>
        <td>
            Địa chỉ liên lạc (*):
        </td>
        <td>
            ${detail.livingOfAddress} ${detail.wardOfAddress} ${detail.districtOfAddress} ${detail.cityOfAddress}
        </td>
    </tr>
    <tr>
        <td>
            Điện thoại (*):
        </td>
        <td>
            ${detail.phone}
        </td>
    </tr>
    <tr>
        <td>
            Email (*):
        </td>
        <td>
            ${detail.email}
        </td>
    </tr>
    <tr>
        <td>
            Trong 14 ngày qua, Anh/Chị có các triệu chứng (*):
        </td>
        <td>
            ${detail.symptom}
        </td>
    </tr>
    <tr>
        <td>
            Trong 14 ngày qua, Anh/Chị có các lịch sử phơi nhiễm (*):
        </td>
        <td>
            ${detail.symptom}
        </td>
    </tr>
</table>
</body>
</html>
