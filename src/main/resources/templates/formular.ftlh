[#ftl]
[@c.page]
    <div class="detail">
        [@form.form class="vizitka" novalidate="novalidate" bind="vizitka" method="post" action="${nova?then('/nova','/upravit')}"]
            [@form.input name="id" type="hidden" label=""/]
            [@form.input name="celeJmeno" label="Jméno a příjmení" maxlength="100" required="required" /]
            [@form.input name="firma" label="Firma" maxlength="100" required="required" /]
            [@form.input name="ulice" label="Ulice a číslo popisné" maxlength="100" required="required" /]
            [@form.input name="obec" label="Obec" maxlength="100" required="required" /]
            [@form.input name="psc" label="PSČ" minlength="5" maxlength="5" pattern="[0-9]{5}" required="required" /]
            [@form.input name="email" label="E-mail *" maxlength="100" required="required" type="email" /]
            [@form.input name="telefon" label="Telefon *" maxlength="100" required="required" type="tel" /]
            [@form.input name="web" label="Web *" maxlength="100" required="required" type="url" /]
            <div class="form-controls">
                [#if nova]
                    <button type="submit">Odeslat</button>
                [#else ]
                    <button type="submit">Potvrdit změny</button>
                [/#if]

            </div>

        [/@form.form]

        [@c.back /]
    </div>
[/@c.page]
