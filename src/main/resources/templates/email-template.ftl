<!doctype html>
<html>

<head>
    <meta charset="UTF-8">
    <!-- utf-8 works for most cases -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Forcing initial-scale shouldn't be necessary -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Use the latest (edge) version of IE rendering engine -->
    <title>EmailTemplate-Responsive</title>
    <!-- The title tag shows in email notifications, like Android 4.4. -->
    <!-- Please use an inliner tool to convert all CSS to inline as inpage or external CSS is removed by email clients -->
    <!-- important in CSS is used to prevent the styles of currently inline CSS from overriding the ones mentioned in media queries when corresponding screen sizes are encountered -->

    <!-- CSS Reset -->
    <style type="text/css">
        /* What it does: Remove spaces around the email design added by some email clients. */
        /* Beware: It can remove the padding / margin and add a background color to the compose a reply window. */
        html,
        body {
            margin: 0 !important;
            padding: 0 !important;
            height: 100% !important;
            width: 100% !important;
        }

        /* What it does: Stops email clients resizing small text. */
        * {
            -ms-text-size-adjust: 100%;
            -webkit-text-size-adjust: 100%;
        }

        /* What it does: Forces Outlook.com to display emails full width. */
        .ExternalClass {
            width: 100%;
        }

        /* What is does: Centers email on Android 4.4 */
        div[style*="margin: 16px 0"] {
            margin: 0 !important;
        }

        /* What it does: Stops Outlook from adding extra spacing to tables. */
        table,
        td {
            mso-table-lspace: 0pt !important;
            mso-table-rspace: 0pt !important;
        }

        /* What it does: Fixes webkit padding issue. Fix for Yahoo mail table alignment bug. Applies table-layout to the first 2 tables then removes for anything nested deeper. */
        table {
            border-spacing: 0 !important;
            border-collapse: collapse !important;
            table-layout: fixed !important;
            margin: 0 auto !important;
        }

        table table table {
            table-layout: auto;
        }

        /* What it does: Uses a better rendering method when resizing images in IE. */
        img {
            -ms-interpolation-mode: bicubic;
        }

        /* What it does: Overrides styles added when Yahoo's auto-senses a link. */
        .yshortcuts a {
            border-bottom: none !important;
        }

        /* What it does: Another work-around for iOS meddling in triggered links. */
        a[x-apple-data-detectors] {
            color: inherit !important;
        }

        a {
            background-color: rgb(194, 26, 43);
            box-shadow: 0 5px 0 darkred;
            color: white;
            padding: 1em 1.5em;
            position: relative;
            text-decoration: none;
            text-transform: uppercase;
        }

        a:hover {
            background-color: #ce0606;
        }

        a:active {
            box-shadow: none;
            top: 5px;
        }

        /* Non-Demo Styles */
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
    </style>

    <!-- Progressive Enhancements -->
    <style type="text/css">
        /* What it does: Hover styles for buttons */
        .button-td,
        .button-a {
            transition: all 100ms ease-in;
        }

        .button-td:hover,
        .button-a:hover {
            background: #555555 !important;
            border-color: #555555 !important;
        }

        /* Media Queries */
        @media screen and (max-width: 600px) {

            .email-container {
                width: 100% !important;
            }

            /* What it does: Forces elements to resize to the full width of their container. Useful for resizing images beyond their max-width. */
            .fluid,
            .fluid-centered {
                max-width: 100% !important;
                height: auto !important;
                margin-left: auto !important;
                margin-right: auto !important;
            }

            /* And center justify these ones. */
            .fluid-centered {
                margin-left: auto !important;
                margin-right: auto !important;
            }

            /* What it does: Forces table cells into full-width rows. */
            .stack-column,
            .stack-column-center {
                display: block !important;
                width: 100% !important;
                max-width: 100% !important;
                direction: ltr !important;
            }

            /* And center justify these ones. */
            .stack-column-center {
                text-align: center !important;
            }

            /* What it does: Generic utility class for centering. Useful for images, buttons, and nested tables. */
            .center-on-narrow {
                text-align: center !important;
                display: block !important;
                margin-left: auto !important;
                margin-right: auto !important;
                float: none !important;
            }

            table.center-on-narrow {
                display: inline-block !important;
            }

        }
    </style>
</head>

<body bgcolor="#e0e0e0" width="100%" style="margin: 0;" yahoo="yahoo">
    <table bgcolor="#e0e0e0" cellpadding="0" cellspacing="0" border="0" height="100%" width="100%"
        style="border-collapse:collapse;">
        <tr>
            <td>
                <center style="width: 100%;">

                    <!-- Email Body : BEGIN -->
                    <table cellspacing="0" cellpadding="0" border="0" align="center" bgcolor="#ffffff" width="600"
                        class="email-container">

                        <!-- 1 Column Text : BEGIN -->
                        <tr>
                            <td
                                style="padding: 40px; ; font-family: sans-serif; font-size: 15px; mso-height-rule: exactly; line-height: 20px; color: #555555;">

                                Hi <span style="font-weight: bold">${name}</span>,
                                <br>
                                <br>

                                Someone requested a new password for your Utopia Airlines account.
                                <br>
                                <br>
                                <br>
                                
                                <a href="https://www.utopiaairlines.xyz/password-recovery/?reset=${confirmation}">Reset Password</a>
 
								<br>
                                <br>
                                <br>
                                <br>
                                If you didn't make this request then you can safely ignore this email :)

                                <br>
                                <br>

                                <!-- Button : Begin -->


                                <!-- Button : END -->
                            </td>
                        </tr>
                        <!-- 1 Column Text : BEGIN -->

                        <!-- Background Image with Text : BEGIN -->
                        <tr>
                            <td background="https://i.ibb.co/FhwcHwX/utopia-email.jpg" " bgcolor=" #222222"
                                valign="middle"
                                style="text-align: center; background-position: center center !important; background-size: cover !important;">


                                <div>
                                    <table align="center" border="0" cellpadding="0" cellspacing="0" width="100%">
                                        <tr>
                                            <td valign="middle"
                                                style="text-align: center; padding: 70px; font-family: sans-serif; font-size: 25px; mso-height-rule: exactly; line-height: 20px; color: black;">
                                            </td>
                                        </tr>
                                    </table>
                                </div>

                            </td>
                        </tr>

                    </table>

                </center>
            </td>
        </tr>
    </table>
</body>

</html>