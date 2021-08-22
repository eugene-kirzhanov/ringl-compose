package com.ringl.common.core.resources

data class Country(
    val code: String,
    val dialCode: String,
    val name: String
)

val countries = listOf(
    Country("AF", "+93", "Afghanistan"),
    Country("AX", "+358", "Aland Islands"),
    Country("AL", "+355", "Albania"),
    Country("DZ", "+213", "Algeria"),
    Country("AS", "+1 684", "AmericanSamoa"),
    Country("AD", "+376", "Andorra"),
    Country("AO", "+244", "Angola"),
    Country("AI", "+1 264", "Anguilla"),
    Country("AQ", "+672", "Antarctica"),
    Country("AG", "+1 268", "Antigua and Barbuda"),
    Country("AR", "+54", "Argentina"),
    Country("AM", "+374", "Armenia"),
    Country("AW", "+297", "Aruba"),
    Country("AU", "+61", "Australia"),
    Country("AT", "+43", "Austria"),
    Country("AZ", "+994", "Azerbaijan"),
    Country("BS", "+1 242", "Bahamas"),
    Country("BH", "+973", "Bahrain"),
    Country("BD", "+880", "Bangladesh"),
    Country("BB", "+1 246", "Barbados"),
    Country("BY", "+375", "Belarus"),
    Country("BE", "+32", "Belgium"),
    Country("BZ", "+501", "Belize"),
    Country("BJ", "+229", "Benin"),
    Country("BM", "+1 441", "Bermuda"),
    Country("BT", "+975", "Bhutan"),
    Country("BO", "+591", "Bolivia, Plurinational State of"),
    Country("BA", "+387", "Bosnia and Herzegovina"),
    Country("BW", "+267", "Botswana"),
    Country("BR", "+55", "Brazil"),
    Country("IO", "+246", "British Indian Ocean Territory"),
    Country("BN", "+673", "Brunei Darussalam"),
    Country("BG", "+359", "Bulgaria"),
    Country("BF", "+226", "Burkina Faso"),
    Country("BI", "+257", "Burundi"),
    Country("KH", "+855", "Cambodia"),
    Country("CM", "+237", "Cameroon"),
    Country("CA", "+1", "Canada"),
    Country("CV", "+238", "Cape Verde"),
    Country("KY", "+345", "Cayman Islands"),
    Country("CF", "+236", "Central African Republic"),
    Country("TD", "+235", "Chad"),
    Country("CL", "+56", "Chile"),
    Country("CN", "+86", "China"),
    Country("CX", "+61", "Christmas Island"),
    Country("CC", "+61", "Cocos (Keeling) Islands"),
    Country("CO", "+57", "Colombia"),
    Country("KM", "+269", "Comoros"),
    Country("CG", "+242", "Congo"),
    Country("CD", "+243", "Congo, The Democratic Republic of the Congo"),
    Country("CK", "+682", "Cook Islands"),
    Country("CR", "+506", "Costa Rica"),
    Country("CI", "+225", "Cote d'Ivoire"),
    Country("HR", "+385", "Croatia"),
    Country("CU", "+53", "Cuba"),
    Country("CY", "+357", "Cyprus"),
    Country("CZ", "+420", "Czech Republic"),
    Country("DK", "+45", "Denmark"),
    Country("DJ", "+253", "Djibouti"),
    Country("DM", "+1 767", "Dominica"),
    Country("DO", "+1 849", "Dominican Republic"),
    Country("EC", "+593", "Ecuador"),
    Country("EG", "+20", "Egypt"),
    Country("SV", "+503", "El Salvador"),
    Country("GQ", "+240", "Equatorial Guinea"),
    Country("ER", "+291", "Eritrea"),
    Country("EE", "+372", "Estonia"),
    Country("ET", "+251", "Ethiopia"),
    Country("FK", "+500", "Falkland Islands (Malvinas)"),
    Country("FO", "+298", "Faroe Islands"),
    Country("FJ", "+679", "Fiji"),
    Country("FI", "+358", "Finland"),
    Country("FR", "+33", "France"),
    Country("GF", "+594", "French Guiana"),
    Country("PF", "+689", "French Polynesia"),
    Country("GA", "+241", "Gabon"),
    Country("GM", "+220", "Gambia"),
    Country("GE", "+995", "Georgia"),
    Country("DE", "+49", "Germany"),
    Country("GH", "+233", "Ghana"),
    Country("GI", "+350", "Gibraltar"),
    Country("GR", "+30", "Greece"),
    Country("GL", "+299", "Greenland"),
    Country("GD", "+1 473", "Grenada"),
    Country("GP", "+590", "Guadeloupe"),
    Country("GU", "+1 671", "Guam"),
    Country("GT", "+502", "Guatemala"),
    Country("GG", "+44", "Guernsey"),
    Country("GN", "+224", "Guinea"),
    Country("GW", "+245", "Guinea-Bissau"),
    Country("GY", "+595", "Guyana"),
    Country("HT", "+509", "Haiti"),
    Country("VA", "+379", "Holy See (Vatican City State)"),
    Country("HN", "+504", "Honduras"),
    Country("HK", "+852", "Hong Kong"),
    Country("HU", "+36", "Hungary"),
    Country("IS", "+354", "Iceland"),
    Country("IN", "+91", "India"),
    Country("ID", "+62", "Indonesia"),
    Country("IR", "+98", "Iran, Islamic Republic of Persian Gulf"),
    Country("IQ", "+964", "Iraq"),
    Country("IE", "+353", "Ireland"),
    Country("IM", "+44", "Isle of Man"),
    Country("IL", "+972", "Israel"),
    Country("IT", "+39", "Italy"),
    Country("JM", "+1 876", "Jamaica"),
    Country("JP", "+81", "Japan"),
    Country("JE", "+44", "Jersey"),
    Country("JO", "+962", "Jordan"),
    Country("KZ", "+7", "Kazakhstan"),
    Country("KE", "+254", "Kenya"),
    Country("KI", "+686", "Kiribati"),
    Country("KP", "+850", "Korea, Democratic People's Republic of Korea"),
    Country("KR", "+82", "Korea, Republic of South Korea"),
    Country("KW", "+965", "Kuwait"),
    Country("KG", "+996", "Kyrgyzstan"),
    Country("LA", "+856", "Laos"),
    Country("LV", "+371", "Latvia"),
    Country("LB", "+961", "Lebanon"),
    Country("LS", "+266", "Lesotho"),
    Country("LR", "+231", "Liberia"),
    Country("LY", "+218", "Libyan Arab Jamahiriya"),
    Country("LI", "+423", "Liechtenstein"),
    Country("LT", "+370", "Lithuania"),
    Country("LU", "+352", "Luxembourg"),
    Country("MO", "+853", "Macao"),
    Country("MK", "+389", "Macedonia"),
    Country("MG", "+261", "Madagascar"),
    Country("MW", "+265", "Malawi"),
    Country("MY", "+60", "Malaysia"),
    Country("MV", "+960", "Maldives"),
    Country("ML", "+223", "Mali"),
    Country("MT", "+356", "Malta"),
    Country("MH", "+692", "Marshall Islands"),
    Country("MQ", "+596", "Martinique"),
    Country("MR", "+222", "Mauritania"),
    Country("MU", "+230", "Mauritius"),
    Country("YT", "+262", "Mayotte"),
    Country("MX", "+52", "Mexico"),
    Country("FM", "+691", "Micronesia, Federated States of Micronesia"),
    Country("MD", "+373", "Moldova"),
    Country("MC", "+377", "Monaco"),
    Country("MN", "+976", "Mongolia"),
    Country("ME", "+382", "Montenegro"),
    Country("MS", "+1 664", "Montserrat"),
    Country("MA", "+212", "Morocco"),
    Country("MZ", "+258", "Mozambique"),
    Country("MM", "+95", "Myanmar"),
    Country("NA", "+264", "Namibia"),
    Country("NR", "+674", "Nauru"),
    Country("NP", "+977", "Nepal"),
    Country("NL", "+31", "Netherlands"),
    Country("AN", "+599", "Netherlands Antilles"),
    Country("NC", "+687", "New Caledonia"),
    Country("NZ", "+64", "New Zealand"),
    Country("NI", "+505", "Nicaragua"),
    Country("NE", "+227", "Niger"),
    Country("NG", "+234", "Nigeria"),
    Country("NU", "+683", "Niue"),
    Country("NF", "+672", "Norfolk Island"),
    Country("MP", "+1 670", "Northern Mariana Islands"),
    Country("NO", "+47", "Norway"),
    Country("OM", "+968", "Oman"),
    Country("PK", "+92", "Pakistan"),
    Country("PW", "+680", "Palau"),
    Country("PS", "+970", "Palestinian Territory, Occupied"),
    Country("PA", "+507", "Panama"),
    Country("PG", "+675", "Papua New Guinea"),
    Country("PY", "+595", "Paraguay"),
    Country("PE", "+51", "Peru"),
    Country("PH", "+63", "Philippines"),
    Country("PN", "+872", "Pitcairn"),
    Country("PL", "+48", "Poland"),
    Country("PT", "+351", "Portugal"),
    Country("PR", "+1 939", "Puerto Rico"),
    Country("QA", "+974", "Qatar"),
    Country("RO", "+40", "Romania"),
    Country("RU", "+7", "Russia"),
    Country("RW", "+250", "Rwanda"),
    Country("RE", "+262", "Reunion"),
    Country("BL", "+590", "Saint Barthelemy"),
    Country("SH", "+290", "Saint Helena, Ascension and Tristan Da Cunha"),
    Country("KN", "+1 869", "Saint Kitts and Nevis"),
    Country("LC", "+1 758", "Saint Lucia"),
    Country("MF", "+590", "Saint Martin"),
    Country("PM", "+508", "Saint Pierre and Miquelon"),
    Country("VC", "+1 784", "Saint Vincent and the Grenadines"),
    Country("WS", "+685", "Samoa"),
    Country("SM", "+378", "San Marino"),
    Country("ST", "+239", "Sao Tome and Principe"),
    Country("SA", "+966", "Saudi Arabia"),
    Country("SN", "+221", "Senegal"),
    Country("RS", "+381", "Serbia"),
    Country("SC", "+248", "Seychelles"),
    Country("SL", "+232", "Sierra Leone"),
    Country("SG", "+65", "Singapore"),
    Country("SK", "+421", "Slovakia"),
    Country("SI", "+386", "Slovenia"),
    Country("SB", "+677", "Solomon Islands"),
    Country("SO", "+252", "Somalia"),
    Country("ZA", "+27", "South Africa"),
    Country("GS", "+500", "South Georgia and the South Sandwich Islands"),
    Country("ES", "+34", "Spain"),
    Country("LK", "+94", "Sri Lanka"),
    Country("SD", "+249", "Sudan"),
    Country("SR", "+597", "Suriname"),
    Country("SJ", "+47", "Svalbard and Jan Mayen"),
    Country("SZ", "+268", "Swaziland"),
    Country("SE", "+46", "Sweden"),
    Country("CH", "+41", "Switzerland"),
    Country("SY", "+963", "Syrian Arab Republic"),
    Country("TW", "+886", "Taiwan"),
    Country("TJ", "+992", "Tajikistan"),
    Country("TZ", "+255", "Tanzania, United Republic of Tanzania"),
    Country("TH", "+66", "Thailand"),
    Country("TL", "+670", "Timor-Leste"),
    Country("TG", "+228", "Togo"),
    Country("TK", "+690", "Tokelau"),
    Country("TO", "+676", "Tonga"),
    Country("TT", "+1 868", "Trinidad and Tobago"),
    Country("TN", "+216", "Tunisia"),
    Country("TR", "+90", "Turkey"),
    Country("TM", "+993", "Turkmenistan"),
    Country("TC", "+1 649", "Turks and Caicos Islands"),
    Country("TV", "+688", "Tuvalu"),
    Country("UG", "+256", "Uganda"),
    Country("UA", "+380", "Ukraine"),
    Country("AE", "+971", "United Arab Emirates"),
    Country("GB", "+44", "United Kingdom"),
    Country("US", "+1", "United States"),
    Country("UY", "+598", "Uruguay"),
    Country("UZ", "+998", "Uzbekistan"),
    Country("VU", "+678", "Vanuatu"),
    Country("VE", "+58", "Venezuela, Bolivarian Republic of Venezuela"),
    Country("VN", "+84", "Vietnam"),
    Country("VG", "+1 284", "Virgin Islands, British"),
    Country("VI", "+1 340", "Virgin Islands, U.S."),
    Country("WF", "+681", "Wallis and Futuna"),
    Country("YE", "+967", "Yemen"),
    Country("ZM", "+260", "Zambia"),
    Country("ZW", "+263", "Zimbabwe")
)
    .sortedBy { it.name }