<?xml version="1.0" encoding="utf-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method = "html"/>
    <xsl:template match="/Readers">
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
    <xsl:template match="/Readers/Reader">
        <tr> <xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/Readers/Reader/Name">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Readers/Reader/ID">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Readers/Reader/Age">
    <td><xsl:apply-templates/></td>
</xsl:template>
    <xsl:template match="/Readers/Reader/Books">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/Readers/Reader/Books/Book">
        <xsl:apply-templates/><br></br>
    </xsl:template>

</xsl:stylesheet>