use furama;
-- 2 Hien thi ten nhan vien có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự
SELECT
    *
FROM
    nhan_vien
WHERE
    ho_ten REGEXP '[HKT][a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+$'
    and CHAR_LENGTH(ho_ten) <= 15;
-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
SELECT
    *,
    ROUND(DATEDIFF(CURDATE(), ngay_sinh) / 365, 0) AS age
FROM
    khach_hang
WHERE
    dia_chi LIKE '%Quảng Trị'
    or dia_chi LIKE '%Đà Nẵng'
HAVING
    age >= 18
    and age <= 50;
-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
SELECT
    KH.ho_ten,
    COUNT(HD.ma_hop_dong) so_lan_dat_phong
FROM
    hop_dong HD
    JOIN khach_hang KH ON HD.ma_khach_hang = KH.ma_khach_hang
    JOIN loai_khach LK ON KH.ma_loai_khach = LK.ma_loai_khach
WHERE
    KH.ma_loai_khach = 1
GROUP BY
    KH.ho_ten
ORDER BY
    so_lan_dat_phong;
-- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
SELECT
    DISTINCT KH.ma_khach_hang,
    KH.ho_ten,
    LK.ten_loai_khach,
    HD.ma_hop_dong,
    DV.ten_dich_vu,
    HD.ngay_lam_hop_dong,
    HD.ngay_ket_thuc,
    (DV.chi_phi_thue + TDV.tien_dich_vu_di_kem) tong_tien
FROM
    loai_khach LK
    RIGHT JOIN khach_hang KH ON KH.ma_loai_khach = LK.ma_loai_khach
    left JOIN hop_dong HD ON KH.ma_khach_hang = HD.ma_khach_hang
    left JOIN dich_vu DV ON HD.ma_dich_vu = DV.ma_dich_vu
    left JOIN (
        SELECT
            HD.ma_hop_dong,
            IFNULL(sum(HDCT.so_luong * DVDK.gia), 0) tien_dich_vu_di_kem
        FROM
            hop_dong HD
            left JOIN hop_dong_chi_tiet HDCT on HDCT.ma_hop_dong = HD.ma_hop_dong
            left JOIN dich_vu_di_kem DVDK ON HDCT.ma_dich_vu_di_kem = DVDK.ma_dich_vu_di_kem
        GROUP BY
            HD.ma_hop_dong
    ) TDV ON HD.ma_hop_dong = TDV.ma_hop_dong;
-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
SELECT
    DV.ma_dich_vu,
    DV.ten_dich_vu,
    DV.dien_tich,
    DV.chi_phi_thue,
    LDV.ten_loai_dich_vu
FROM
    dich_vu DV
    RIGHT JOIN loai_dich_vu LDV ON DV.ma_loai_dich_vu = LDV.ma_loai_dich_vu
    JOIN hop_dong HD on HD.ma_dich_vu = DV.ma_dich_vu
WHERE
    DV.ma_dich_vu not IN (
        SELECT
            DV.ma_dich_vu
        FROM
            dich_vu DV
            LEFT JOIN hop_dong HD on HD.ma_dich_vu = DV.ma_dich_vu
        WHERE
            year(HD.ngay_lam_hop_dong) = 2021
            AND MONTH(HD.ngay_lam_hop_dong) in (1, 2, 3)
    )
GROUP by
    DV.ma_dich_vu;
-- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
SELECT
    DV.ma_dich_vu,
    DV.ten_dich_vu,
    DV.dien_tich,
    DV.so_nguoi_toi_da,
    DV.chi_phi_thue,
    LDV.ten_loai_dich_vu
FROM
    dich_vu DV
    RIGHT JOIN loai_dich_vu LDV ON DV.ma_loai_dich_vu = LDV.ma_loai_dich_vu
    JOIN hop_dong HD on HD.ma_dich_vu = DV.ma_dich_vu
WHERE
    year(HD.ngay_lam_hop_dong) = 2020
    and DV.ma_dich_vu not IN (
        SELECT
            DV.ma_dich_vu
        FROM
            dich_vu DV
            LEFT JOIN hop_dong HD on HD.ma_dich_vu = DV.ma_dich_vu
        WHERE
            year(HD.ngay_lam_hop_dong) = 2021
    )
GROUP by
    DV.ma_dich_vu;
-- 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.
SELECT
    DISTINCT ho_ten
FROM
    khach_hang;
SELECT
    ho_ten
FROM
    khach_hang
GROUP BY
    ho_ten;
SELECT
    ho_ten
FROM
    khach_hang
UNION
SELECT
    ho_ten
FROM
    khach_hang;
-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
SELECT
    tmp.thang,
    thang_khach_dat.so_khach_dat
FROM
    (
        SELECT
            1 AS thang
        UNION
        SELECT
            2 AS thang
        UNION
        SELECT
            3 AS thang
        UNION
        SELECT
            4 AS thang
        UNION
        SELECT
            5 AS thang
        UNION
        SELECT
            6 AS thang
        UNION
        SELECT
            7 AS thang
        UNION
        SELECT
            8 AS thang
        UNION
        SELECT
            9 AS thang
        UNION
        SELECT
            10 AS thang
        UNION
        SELECT
            11 AS thang
        UNION
        SELECT
            12 AS thang
    ) AS tmp
    LEFT JOIN (
        SELECT
            MONTH(HD.ngay_lam_hop_dong) thang,
            COUNT(HD.ma_khach_hang) so_khach_dat
        FROM
            hop_dong HD
        WHERE
            YEAR(HD.ngay_lam_hop_dong) = 2021
        GROUP by
            thang
    ) thang_khach_dat on tmp.thang = thang_khach_dat.thang;
-- 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
SELECT
    HD.ma_hop_dong,
    HD.ngay_lam_hop_dong,
    HD.ngay_ket_thuc,
    SUM(so_luong) so_luong_dich_vu_kem
FROM
    hop_dong HD
    left JOIN hop_dong_chi_tiet HDCT on HDCT.ma_hop_dong = HD.ma_hop_dong
GROUP BY
    HD.ma_hop_dong;
-- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
SELECT
    DVDK.ten_dich_vu_di_kem,
    DVDK.ma_dich_vu_di_kem
FROM
    dich_vu_di_kem DVDK
    JOIN hop_dong_chi_tiet HDCT ON DVDK.ma_dich_vu_di_kem = HDCT.ma_dich_vu_di_kem
    JOIN hop_dong HD ON HDCT.ma_hop_dong = HD.ma_hop_dong
    JOIN khach_hang KH on HD.ma_khach_hang = KH.ma_khach_hang
    JOIN loai_khach LK on KH.ma_loai_khach = LK.ma_loai_khach
WHERE
    LK.ten_loai_khach = 'Diamond'
    AND (
        KH.dia_chi LIKE '%Vinh'
        or KH.dia_chi LIKE '%Quảng Ngãi'
    );
-- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhan vien), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
SELECT
    HD.ma_hop_dong,
    NV.ho_ten nhan_vien,
    KH.ho_ten khach_hang,
    KH.so_dien_thoai,
    DV.ten_dich_vu,
    ifnull(SUM(HDCT.so_luong), 0) so_luong_dich_vu_kem,
    HD.tien_dat_coc
FROM
    khach_hang KH
    JOIN hop_dong HD ON KH.ma_khach_hang = HD.ma_khach_hang
    left JOIN hop_dong_chi_tiet HDCT on HDCT.ma_hop_dong = HD.ma_hop_dong
    JOIN nhan_vien NV on NV.ma_nhan_vien = HD.ma_nhan_vien
    JOIN dich_vu DV ON HD.ma_dich_vu = DV.ma_dich_vu
WHERE
    year(HD.ngay_lam_hop_dong) = 2020
    and MONTH(HD.ngay_lam_hop_dong) in (10, 11, 12)
    and DV.ma_dich_vu not IN (
        SELECT
            DV.ma_dich_vu
        FROM
            dich_vu DV
            LEFT JOIN hop_dong HD on HD.ma_dich_vu = DV.ma_dich_vu
        WHERE
            year(HD.ngay_lam_hop_dong) = 2021
            and MONTH(HD.ngay_lam_hop_dong) in (1, 2, 3, 4, 5, 6)
    )
GROUP BY
    KH.ma_khach_hang;
-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
SELECT
    DVDK.ma_dich_vu_di_kem,
    DVDK.ten_dich_vu_di_kem,
    sum(HDCT.so_luong) so_lan_dat
FROM
    dich_vu_di_kem DVDK
    right JOIN hop_dong_chi_tiet HDCT on HDCT.ma_dich_vu_di_kem = DVDK.ma_dich_vu_di_kem
GROUP BY
    DVDK.ma_dich_vu_di_kem
HAVING
    so_lan_dat >= all(
        select
            sum(HDCT.so_luong)
        FROM
            hop_dong_chi_tiet HDCT
        GROUP BY
            HDCT.ma_dich_vu_di_kem
    );
-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).
SELECT
    HD.ma_hop_dong,
    LDV.ten_loai_dich_vu,
    DVDK.ten_dich_vu_di_kem,
    HDCT.so_luong
FROM
    dich_vu_di_kem DVDK
    JOIN hop_dong_chi_tiet HDCT on HDCT.ma_dich_vu_di_kem = DVDK.ma_dich_vu_di_kem
    JOIN hop_dong HD ON HD.ma_hop_dong = HDCT.ma_hop_dong
    JOIN dich_vu DV ON DV.ma_dich_vu = HD.ma_dich_vu
    JOIN loai_dich_vu LDV ON LDV.ma_loai_dich_vu = DV.ma_loai_dich_vu
WHERE
    HDCT.so_luong = 1;
-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
SELECT
    NV.ma_nhan_vien,
    NV.ho_ten,
    TD.ten_trinh_do,
    BP.ten_bo_phan,
    NV.so_dien_thoai,
    NV.dia_chi,
    count(HD.ma_nhan_vien) so_hop_dong
FROM
    nhan_vien NV
    JOIN trinh_do TD ON NV.ma_trinh_do = TD.ma_trinh_do
    JOIN bo_phan BP ON NV.ma_bo_phan = BP.ma_bo_phan
    JOIN hop_dong HD ON HD.ma_nhan_vien = NV.ma_nhan_vien
WHERE
    year(HD.ngay_lam_hop_dong) in (2020, 2021)
GROUP BY
    HD.ma_nhan_vien
HAVING
    so_hop_dong <= 3;
-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
DELETE FROM
    nhan_vien NV
WHERE
    NOT EXISTS (
        select
            *
        from
            hop_dong HD
        WHERE
            HD.ma_nhan_vien = NV.ma_nhan_vien
            and YEAR(HD.ngay_lam_hop_dong) BETWEEN 2019
            and 2021
    );
--     17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
UPDATE
    khach_hang KH
SET
    ma_loai_khach = 1
WHERE
    ma_khach_hang = (
        SELECT
            ma_khach_hang
        FROM
            (
                SELECT
                    DISTINCT KH.ma_khach_hang
                FROM
                    loai_khach LK
                    RIGHT JOIN khach_hang KH ON KH.ma_loai_khach = LK.ma_loai_khach
                    left JOIN hop_dong HD ON KH.ma_khach_hang = HD.ma_khach_hang
                    left JOIN dich_vu DV ON HD.ma_dich_vu = DV.ma_dich_vu
                    left JOIN (
                        SELECT
                            HD.ma_hop_dong,
                            IFNULL(sum(HDCT.so_luong * DVDK.gia), 0) tien_dich_vu_di_kem
                        FROM
                            hop_dong HD
                            left JOIN hop_dong_chi_tiet HDCT on HDCT.ma_hop_dong = HD.ma_hop_dong
                            left JOIN dich_vu_di_kem DVDK ON HDCT.ma_dich_vu_di_kem = DVDK.ma_dich_vu_di_kem
                        GROUP BY
                            HD.ma_hop_dong
                    ) TDV ON HD.ma_hop_dong = TDV.ma_hop_dong
                WHERE
                    LK.ten_loai_khach = 'Platinium'
                    AND YEAR(HD.ngay_lam_hop_dong) = 2021
                    and (DV.chi_phi_thue + TDV.tien_dich_vu_di_kem) >= 10000000
            ) tmp
    );
-- 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
set foreign_key_checks = 1;
DELETE FROM
    khach_hang KH
WHERE
    EXISTS (
        select
            *
        from
            hop_dong HD
        WHERE
            HD.ma_khach_hang = KH.ma_khach_hang
            and YEAR(HD.ngay_lam_hop_dong) <=2021
    );
-- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi. 
UPDATE dich_vu_di_kem
SET gia = gia * 2
WHERE ma_dich_vu_di_kem = 
(SELECT ma_dich_vu_di_kem FROM
(SELECT
    DVDK.ma_dich_vu_di_kem,
    HDCT.so_luong
FROM
    dich_vu_di_kem DVDK
    JOIN hop_dong_chi_tiet HDCT on HDCT.ma_dich_vu_di_kem = DVDK.ma_dich_vu_di_kem
    JOIN hop_dong HD ON HD.ma_hop_dong = HDCT.ma_hop_dong
WHERE
    HDCT.so_luong >=10
    AND YEAR(HD.ngay_lam_hop_dong) =2020
    GROUP BY HDCT.ma_dich_vu_di_kem)tmp);
-- 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
SELECT NV.ma_nhan_vien ma_so, NV.ho_ten, NV.email, NV.so_dien_thoai, NV.ngay_sinh, NV.dia_chi FROM nhan_vien NV
UNION ALL
select KH.ma_khach_hang, KH.ho_ten, KH.email, KH.so_dien_thoai, KH.ngay_sinh, KH.dia_chi FROM khach_hang KH;
