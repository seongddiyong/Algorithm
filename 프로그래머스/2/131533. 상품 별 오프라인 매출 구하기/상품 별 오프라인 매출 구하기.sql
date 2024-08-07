SELECT P.PRODUCT_CODE, P.PRICE*SUM(OS.SALES_AMOUNT) AS SALES
FROM OFFLINE_SALE AS OS
    INNER JOIN PRODUCT AS P ON OS.PRODUCT_ID = P.PRODUCT_ID
GROUP BY OS.PRODUCT_ID
ORDER BY SALES DESC, P.PRODUCT_CODE ASC