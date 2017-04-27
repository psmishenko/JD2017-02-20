<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>
<xsl:template match="/">
    <html>
        <head>
            <title>Товарные накладные</title>
        </head>
        <body>
            <xsl:apply-templates/>
        </body>
    </html>
</xsl:template>
<xsl:template match="/Naklads/Naklad" >
    <br/>
    <table border="1">
        <tr>
            <td><b>Тип</b></td>
            <td><b>Дата</b></td>
            <td><b>Серия</b></td>
            <td><b>Номер</b></td>
            <td><b>Клиент</b></td>
            <td><b>УНП клиента</b></td>
            <td><b>Адрес клиента</b></td>
            <td><b>Автомобиль №</b></td>
            <td><b>Водитель</b></td>
        </tr>
        <tr>
            <td>
                <xsl:choose>
                    <xsl:when test="attribute::type = 'TN_IN'">Входящая ТН</xsl:when>
                    <xsl:when test="attribute::type = 'TTN_IN'">Входящая ТТН</xsl:when>
                    <xsl:when test="attribute::type = 'TN_OUT'">Исходящая ТН</xsl:when>
                    <xsl:when test="attribute::type = 'TTN_OUT'">Исходящая ТТН</xsl:when>
                    <xsl:otherwise><xsl:value-of select="attribute::type"/></xsl:otherwise>
                </xsl:choose>
            </td>
            <td><xsl:value-of select="Date"/></td>
            <td align="center"><xsl:value-of select="Seria"/></td>
            <td><xsl:value-of select="Num"/></td>
            <td><xsl:value-of select="Klient/Name"/></td>
            <td><xsl:value-of select="Klient/Unp"/></td>
            <td><xsl:value-of select="Klient/Adres"/></td>
            <td><xsl:value-of select="Avto/NumGos"/></td>
            <td><xsl:value-of select="Avto/Voditel"/></td>
        </tr>
        <xsl:apply-templates select="Tovars"/>
    </table>
</xsl:template>
<xsl:template match="/Naklads/Naklad/Tovars">
    <tr>
        <td colspan="9"><b><i>Состав товарной накладной</i></b></td>
    </tr>
    <tr>
        <td colspan="2"><b><i>Наименование товара</i></b></td>
        <td><b><i>Ед. изм.</i></b></td>
        <td><b><i>Количество</i></b></td>
        <td><b><i>Цена</i></b></td>
        <td><b><i>Стоимость</i></b></td>
        <td><b><i>%НДС</i></b></td>
        <td><b><i>Сумма НДС</i></b></td>
        <td><b><i>Стоимость с НДС</i></b></td>
    </tr>
    <xsl:apply-templates/>
</xsl:template>
<xsl:template match="/Naklads/Naklad/Tovars/Tovar">
    <tr>
        <td colspan="2"><i><xsl:value-of select="Name"/></i></td>
        <td align="center"><i><xsl:value-of select="EdIzm"/></i></td>
        <td align="right"><i><xsl:value-of select="Count"/></i></td>
        <td align="right"><i><xsl:value-of select="Cena"/></i></td>
        <td align="right"><i><xsl:value-of select="Stoim"/></i></td>
        <td align="right"><i><xsl:value-of select="PrNds"/></i></td>
        <td align="right"><i><xsl:value-of select="Nds"/></i></td>
        <td align="right"><i><xsl:value-of select="StoimPoln"/></i></td>
    </tr>
</xsl:template>
</xsl:stylesheet>