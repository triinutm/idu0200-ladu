<?xml version="1.0" encoding="ISO-8859-1"?>
<!-- Edited by XMLSpy® -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
    <table border="1">
      <tr bgcolor="#CEE3F6">
        <th colspan="2">Saadavus ladudes</th>
      </tr>
      <xsl:for-each select="itemstorelist/itemstore">
      <tr>
        <td><xsl:value-of select="store/name"/></td>
        <td><xsl:value-of select="itemCount"/></td>
      </tr>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>