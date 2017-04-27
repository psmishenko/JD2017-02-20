<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/InternetShop">
            <table border="1">
                <tr><td>Catalog</td><td>Order</td><td>BlackList</td></tr>
        <xsl:apply-templates/>
    </table>
        <table border="2">
        <tr><td>MadeOrder</td><td>PayOreder</td></tr>
            <xsl:apply-templates/>
        </table>
        <table border="3">
            <tr><td>Profit</td><td>Count</td><td>Sale</td></tr>
            <xsl:apply-templates/>
        </table>
        <table border="4">
            <tr><td>Client_id</td></tr>
            <xsl:apply-templates/>
        </table>
</xsl:template>

    <xsl:template match="/InternetShop/Administrator">
    <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/InternetShop/Administrator/Catalog">
    <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/InternetShop/Administrator/Order">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/InternetShop/Administrator/BlackList">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/InternetShop/Client/MadeOrder">
    <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/InternetShop/Client/PayOreder">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/InternetShop/OrderC/Profit">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>


    <xsl:template match="/InternetShop/OrderC/Count">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>


    <xsl:template match="/InternetShop/OrderC/Sale">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/InternetShop/BlackListStatus/Client_id">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>
</xsl:stylesheet>