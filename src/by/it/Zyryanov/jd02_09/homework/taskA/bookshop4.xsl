<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" />
    <xsl:template match="/BookShop">
        <table border="1"><xsl:apply-templates/></table>
    </xsl:template>
    <xsl:template match="/BookShop/Book_Catalogue/Book">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/BookShop/Book_Catalogue/Book/Book_title">
        <td><b>Book Title</b> <br/> <xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/BookShop/Book_Catalogue/Book/Author">
        <td><b>Author</b> <br/> <xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/BookShop/Book_Catalogue/Book/Genre">
        <td><b>Genre</b> <br/> <xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/BookShop/Book_Catalogue/Book/Pages">
        <td><b>Pages</b> <br/> <xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/BookShop/Book_Catalogue/Book/Description">
        <td><b>Description</b> <br/> <xsl:apply-templates/></td>
    </xsl:template>
</xsl:stylesheet>