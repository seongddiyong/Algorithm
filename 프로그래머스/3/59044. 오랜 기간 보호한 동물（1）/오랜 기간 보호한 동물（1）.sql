-- 코드를 입력하세요
SELECT I.NAME, I.DATETIME
FROM ANIMAL_INS AS I
WHERE NOT EXISTS (SELECT ANIMAL_ID FROM ANIMAL_OUTS AS O WHERE I.ANIMAL_ID = O.ANIMAL_ID)
ORDER BY I.DATETIME
LIMIT 3