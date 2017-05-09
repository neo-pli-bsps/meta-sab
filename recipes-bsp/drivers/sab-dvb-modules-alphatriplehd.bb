SUMMARY = "Hardware drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

KV = "4.1.24"
GCCREV = "4.9.1"
SRCDATE = "20170508"

SRC_URI[md5sum] = "3A10E7ABBD0228CADB0B189AA5A94B32"
SRC_URI[sha256sum] = "6ADA5DE766887A245C0F3FCF1031112628FCEE40BD11F2DDA781BB07CC5792FE"

PV = "${KV}+${SRCDATE}"
PR = "r0"

SRC_URI = "http://dvbstand.com/alphatriplehd/drivers/alphatriple-drivers-${KV}-${GCCREV}-${SRCDATE}.zip"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

inherit module

do_compile() {
}

do_install() {
    install -d ${D}/lib/modules/${KV}/extra
    install -d ${D}/${sysconfdir}/modules-load.d
    install -m 0755 ${WORKDIR}/linuxtv.ko ${D}/lib/modules/${KV}/extra
    echo linuxtv >> ${D}/${sysconfdir}/modules-load.d/_${MACHINE}.conf
}

FILES_${PN} += "${sysconfdir}/modules-load.d/_${MACHINE}.conf"

