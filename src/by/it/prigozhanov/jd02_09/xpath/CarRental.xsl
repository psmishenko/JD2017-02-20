<?xml version="1.0" encoding="utf-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>


    <xsl:template match="/CarList/SportCars">
        <table border="1" cellspacing="0" cellpadding="10">
            <tr>
                <td>Discription</td>
                <td>Model Name</td>
                <td>Horse Power</td>
                <td>Fuel Consumption</td>
                <td>Seats</td>
                <td>Doors</td>
                <td>Luggage Capacity</td>
                <td>Price</td>
                <td>Location</td>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>
    <xsl:template match="CarList/SportCars/Car">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>
    <xsl:template match="CarList/SportCars/Car/Discription">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
    <xsl:template match="CarList/SportCars/Car/Model">

            <xsl:apply-templates/>

    </xsl:template>
    <xsl:template match="CarList/SportCars/Car/Price">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>
    <xsl:template match="CarList/SportCars/Car/Location">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
    <xsl:template match="CarList/SportCars/Car/Model/Name">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
    <xsl:template match="CarList/SportCars/Car/Model/HP">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
    <xsl:template match="CarList/SportCars/Car/Model/FuelConsumption">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
    <xsl:template match="CarList/SportCars/Car/Model/Seats">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
    <xsl:template match="CarList/SportCars/Car/Model/Doors">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
    <xsl:template match="CarList/SportCars/Car/Model/LuggageCapacity">
        <td>
            <xsl:value-of select="text()"/>
        </td>
    </xsl:template>
    <xsl:template match="CarList/SportCars/Car/Price">
        <td>
            <xsl:value-of select="attribute::GBP"/>
            <xsl:value-of select="attribute::RUB"/>
            <xsl:value-of select="attribute::EUR"/>
        </td>
    </xsl:template>

</xsl:stylesheet>