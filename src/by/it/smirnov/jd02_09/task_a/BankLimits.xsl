<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/BankLimits">
           <xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="BankLimits/Banks">
        <head/>
        <body>
            <table border="1">
                <tr>
                    <td>
                        <b>Наименование</b>
                    </td>
                    <td>
                        <b>МФО</b>
                    </td>
                    <td>
                        <b>Полное МФО</b>
                    </td>
                    <td>
                        <b>Адрес</b>
                    </td>
                    <td>
                        <b>Группа</b>
                    </td>
                </tr>
                <xsl:apply-templates/>
            </table>
        </body>
    </xsl:template>

    <xsl:template match="BankLimits/Banks/Bank">
        <tr>
            <xsl:apply-templates/>
        </tr>
    </xsl:template>

    <xsl:template match="BankLimits/Banks/Bank/Name">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="BankLimits/Banks/Bank/MFO">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="BankLimits/Banks/Bank/FullMFO">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="BankLimits/Banks/Bank/Group">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="BankLimits/Banks/Bank/Address">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="BankLimits/Banks/Bank/Address/PostIndex">
        <xsl:apply-templates/>,
    </xsl:template>

    <xsl:template match="BankLimits/Banks/Bank/Address/Country">
        <xsl:apply-templates/>,
    </xsl:template>

    <xsl:template match="BankLimits/Banks/Bank/Address/City">
        <xsl:apply-templates/>,
    </xsl:template>

    <xsl:template match="BankLimits/Banks/Bank/Address/Street">
        <xsl:apply-templates/>,
    </xsl:template>

    <xsl:template match="BankLimits/Banks/Bank/Address/Number">
        д.
        <xsl:apply-templates/>
    </xsl:template>

    <xsl:template match="BankLimits/Limits">
            <table border="1">
                <tr>
                    <td>
                        <b>Лимиты на группы</b>
                    </td>
                </tr>
                <xsl:apply-templates/>
            </table>
    </xsl:template>

    <xsl:template match="BankLimits/Limits/Limit">
        <tr>
            <td>
                Группа: <xsl:apply-templates select="@group"/>
                <xsl:apply-templates/>
            </td>
        </tr>
    </xsl:template>

    <xsl:template match="BankLimits/Limits/Limit/Lim">
        <tr>
            <td>
                <i>С даты: <xsl:apply-templates select="@fromDate"/></i>
                <xsl:apply-templates/>
            </td>
        </tr>
    </xsl:template>

    <xsl:template match="BankLimits/Limits/Limit/Lim/Opers">
        <table border="1">
            <xsl:apply-templates/>
        </table>
    </xsl:template>

    <xsl:template match="BankLimits/Limits/Limit/Lim/Opers/Oper">
        <tr>
            <td>
                Тип операции: <xsl:apply-templates select="@type"/>
                <xsl:apply-templates/>
            </td>
        </tr>
    </xsl:template>

    <xsl:template match="BankLimits/Limits/Limit/Lim/Opers/Oper/Summa">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>

    <xsl:template match="BankLimits/Limits/Limit/Lim/Opers/Oper/Valut">
        <td>
            <xsl:apply-templates/>
        </td>
    </xsl:template>


</xsl:stylesheet>