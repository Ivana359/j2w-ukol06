[#ftl]
[@c.page]
    <div class="seznam">
        [#list seznam as udaj]

            <a href="/detail/${udaj.id}">
                <div class="vizitka">
                    <div class="jmeno">${udaj.celeJmeno}</div>
                    <div class="firma">${udaj.firma}</div>
                    <div class="udaje">
                        <div class="adresa">
                            <div>${udaj.ulice}</div>
                            <div><span>${udaj.psc}</span> <span>${udaj.obec}</span></div>
                        </div>
                        <div class="kontakty">
                            [#if udaj.email?has_content]
                                <div><i class="las la-at"></i> <span>${udaj.email}</span></div>
                            [/#if]
                            [#if udaj.telefon?has_content]
                                <div><i class="las la-phone-alt"></i> <span>${udaj.telefon}</span></div>
                            [/#if]
                            [#if udaj.web?has_content]
                                <div><i class="las la-globe"></i> <span>${udaj.web}</span></div>
                            [/#if]
                        </div>
                    </div>
                </div>
            </a>
        [/#list]
        <a href="/nova">
            <div class="vizitka vizitka--nova">
                <svg width="100" height="100">
                    <rect width="20" height="100" x="40" y="0" fill="white"/>
                    <rect width="100" height="20" x="0" y="40" fill="white"/>
                </svg>
            </div>
        </a>
    </div>

[/@c.page]
