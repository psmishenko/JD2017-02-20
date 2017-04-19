<?xml version="1.0" encoding="utf-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method = "html"/>
    <xsl:template match="/readers">
    <table border = "3">
        <tr>
            <td>Name</td>
            <td>ID</td>
            <td>Age</td>
            <td>Books</td>
        </tr>
        <xsl:apply-templates/>
    </table>
    </xsl:template>
    <xsl:template match="/readers/reader">
        <tr> <xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/readers/reader/Name">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/readers/reader/ID">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/readers/reader/Age">
    <td><xsl:apply-templates/></td>
</xsl:template>
    <xsl:template match="/readers/reader/Books">
        <td><xsl:apply-templates/></td>
    </xsl:template>
</xsl:stylesheet>