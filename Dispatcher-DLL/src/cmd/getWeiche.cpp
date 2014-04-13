#include <stdafx.h>

#include <jni.h>

#include "Desm.h"
#include "Middleware.h"
#include "util/JavaJni.h"
#include "util/Json.h"
#include "util/String.h"

extern "C" {
	__declspec(dllexport) int stw_getWeiche(int weicheId, int* gleisId)
	{
		if(!gleisId) {
			return desm::ERROR_API_MISUSE;
		}

		Json::Value v;
		if(!desm::Middleware::get().getCommand(desm::ENUM_CMD_WEICHE, weicheId, v)) {
			return desm::ERROR_API_MISUSE;
		}

		*gleisId = desm::util::jsonGet<int>(v, "gleisId");

		return desm::ERROR_OK;
	}
	
	JNIEXPORT jint JNICALL Java_ch_desm_Dll_getWeiche(JNIEnv* env, jobject obj, jint weicheId)
	{
		int gleisId;
		int rc = stw_getWeiche(weicheId, &gleisId);
		desm::util::jni::checkReturnCode(env, rc);
		return gleisId;
	}
};
