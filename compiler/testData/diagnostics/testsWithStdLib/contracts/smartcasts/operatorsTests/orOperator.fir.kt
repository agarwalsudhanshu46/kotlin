// !LANGUAGE: +AllowContractsForCustomFunctions +UseReturnsEffect
// !USE_EXPERIMENTAL: kotlin.contracts.ExperimentalContracts
// !DIAGNOSTICS: -INVISIBLE_REFERENCE -INVISIBLE_MEMBER
// !WITH_NEW_INFERENCE

import kotlin.contracts.*

fun trueWhenString(x: Any?): Boolean {
    contract {
        returns(true) implies (x is String)
    }
    return x is String
}

fun trueWhenInt(x: Any?): Boolean {
    contract {
        returns(true) implies (x is Int)
    }
    return x is Int
}

fun falseWhenString(x: Any?): Boolean {
    contract {
        returns(false) implies (x is String)
    }
    return x !is String
}

fun falseWhenInt(x: Any?): Boolean {
    contract {
        returns(false) implies (x is Int)
    }
    return x !is Int
}

fun truetrue(x: Any?) {
    if (trueWhenString(x) || trueWhenInt(x)) {
        x.<!UNRESOLVED_REFERENCE!>length<!>
        x.<!AMBIGUITY!>inc<!>()
    }
    else {
        x.<!UNRESOLVED_REFERENCE!>length<!>
        x.<!AMBIGUITY!>inc<!>()
    }
}

fun truefalse(x: Any?) {
    if (trueWhenString(x) || falseWhenInt(x)) {
        x.<!UNRESOLVED_REFERENCE!>length<!>
        x.<!AMBIGUITY!>inc<!>()
    }
    else {
        x.<!UNRESOLVED_REFERENCE!>length<!>
        x.<!AMBIGUITY!>inc<!>()
    }
}

fun falsetrue(x: Any?) {
    if (falseWhenString(x) || trueWhenInt(x)) {
        x.<!UNRESOLVED_REFERENCE!>length<!>
        x.<!AMBIGUITY!>inc<!>()
    }
    else {
        x.<!UNRESOLVED_REFERENCE!>length<!>
        x.<!AMBIGUITY!>inc<!>()
    }
}

fun falsefalse(x: Any?) {
    if (falseWhenString(x) || falseWhenInt(x)) {
        x.<!UNRESOLVED_REFERENCE!>length<!>
        x.<!AMBIGUITY!>inc<!>()
    }
    else {
        x.<!UNRESOLVED_REFERENCE!>length<!>
        x.<!AMBIGUITY!>inc<!>()
    }
}