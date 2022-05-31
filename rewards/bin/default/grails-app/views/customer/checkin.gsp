<!doctype html>
<html>
    <head>
        <title>Kiosk</title>
        <link rel="stylesheet" type="text/css" href="${resource(dir: 'stylesheets', file:'bootstrap.min.css')}" />
        <script src="javascripts/respond.js"></script>
    </head>
    <body>
        <g:form url="[resource:customerInstance, action:'customerLookup']">
                <g:render template="kioskForm" />
        </g:form>

        <g:javascript library="jquery" />
        <script src="javascripts/bootstrap.min.js"></script>
    </body>
</html>
