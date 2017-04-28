<?xml version="1.0" encoding="utf-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method = "html"/>

    <xsl:template match="/Brigades">
        <table border = "1">
            <tr><td>Pilots</td><td>Navigator</td><td>Radio-operator</td><td>Stewardess</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="/Brigades/Brigade">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>

    <xsl:template match="/Brigades/Brigade/Pilots">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Brigades/Brigade/Navigator">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Brigades/Brigade/Radio-operator">
        <td><xsl:apply-templates/></td>
    </xsl:template>

    <xsl:template match="/Brigades/Brigade/Stewardess">
        <td><xsl:apply-templates/></td>
    </xsl:template>

</xsl:stylesheet>