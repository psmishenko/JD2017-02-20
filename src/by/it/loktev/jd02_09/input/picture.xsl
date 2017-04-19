<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html"/>

    <xsl:template match="/picture">
        <table border="1">
            <tr>
                <th>Primitive kind</th>
                <th>Primitive properties</th>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="circle">
        <tr>
            <td>CIRCLE</td>
            <td>
                centerx=<xsl:value-of select="@centerx" />
                centery=<xsl:value-of select="@centery" />
                radius=<xsl:value-of select="@radius" />
                fill=<xsl:value-of select="@fill" />
                stroke=<xsl:value-of select="@stroke" />
            </td>
        </tr>
    </xsl:template>

    <xsl:template match="square">
        <tr>
            <td>SQUARE</td>
            <td>
                left=<xsl:value-of select="@left" />
                top=<xsl:value-of select="@top" />
                width=<xsl:value-of select="@width" />
                height=<xsl:value-of select="@height" />
                fill=<xsl:value-of select="@fill" />
                stroke=<xsl:value-of select="@stroke" />
            </td>
        </tr>
    </xsl:template>

    <xsl:template match="text">
        <tr>
            <td>TEXT</td>
            <td>
                left=<xsl:value-of select="@left" />
                top=<xsl:value-of select="@top" />
                <br /><i><xsl:apply-templates/></i>
            </td>
        </tr>
    </xsl:template>

    <xsl:template match="group">
        <tr>
            <th>GROUP start</th>
            <td></td>
        </tr>
        <xsl:apply-templates/>
        <tr>
            <th>GROUP end</th>
            <td></td>
        </tr>
    </xsl:template>

</xsl:stylesheet>