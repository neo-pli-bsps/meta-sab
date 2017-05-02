SUMMARY = "Hardware drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

KV = "4.1.24"
GCCREV = "4.9.1"
SRCDATE = "20170501"

SRC_URI[md5sum] = "815b4190baf6767b203ecd783e084d56"
SRC_URI[sha256sum] = "6ef8caf9fda3d1d585d804abf660470f5eba54786e6d4ff1b55a952e79003619"

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

